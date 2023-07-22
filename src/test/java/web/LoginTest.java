package web;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;
import web.components.LoginModal;
import web.components.NavBar;

public class LoginTest extends AbstractWebTest {

    @Test
    @TestPriority(Priority.P1)
    public void testLoginModal() {
        LoginModal loginModal = homePage.openLoginModal();
        loginModal.typeUsername(R.TESTDATA.get("user"));
        loginModal.typePassword(R.TESTDATA.get("password"));
        loginModal.clickLoginButton();
        assertTrue(homePage.getNavBar().isUsernameDisplayed(), "Username should be displayed.");
    }

    @Test
    @TestPriority(Priority.P2)
    public void testLogout() {
        LoginModal loginModal = homePage.openLoginModal();
//        loginModal.isUIObjectPresent();
        loginModal.typeUsername(R.TESTDATA.get("user"));
        loginModal.typePassword(R.TESTDATA.get("password"));
        loginModal.clickLoginButton();
        NavBar navBar = homePage.getNavBar();
        assertTrue(navBar.isLogoutDisplayed(), "Logout should be displayed.");
        navBar.clickLogoutButton();
        assertTrue(navBar.isLoginNavButtonDisplayed(), "Login should be displayed.");
        assertFalse(navBar.isUsernameDisplayed(), "Username should not be displayed.");
    }

}
