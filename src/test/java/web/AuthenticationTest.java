package web;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.components.LoginModal;
import web.components.NavBar;

public class AuthenticationTest extends AbstractWebTest {

    @BeforeMethod
    public void beforeLogin() {
        super.before();
        LoginModal loginModal = homePage.openLoginModal();
        loginModal.typeUsername(R.TESTDATA.get("user"));
        loginModal.typePassword(R.TESTDATA.get("password"));
        loginModal.clickLoginButton();
    }

    @Test
    @TestPriority(Priority.P1)
    @MethodOwner(owner = "jinocencio-solvd")
    public void testLoginModal() {
        assertTrue(homePage.getNavBar().isUsernameDisplayed(), "Username should be displayed.");
    }

    @Test
    @TestPriority(Priority.P2)
    @MethodOwner(owner = "jinocencio-solvd")
    public void testLogout() {
        NavBar navBar = homePage.getNavBar();
        assertTrue(navBar.isLogoutDisplayed(), "Logout should be displayed.");
        navBar.clickLogoutButton();
        assertTrue(navBar.isLoginNavButtonDisplayed(), "Login should be displayed.");
        assertFalse(navBar.isUsernameDisplayed(), "Username should not be displayed.");
    }

}
