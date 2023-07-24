package web;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.annotations.Test;
import web.components.NavBar;
import web.utils.AuthUtil;

public class AuthenticationTest extends AbstractWebTest {

    @Test
    @TestPriority(Priority.P1)
    @MethodOwner(owner = "jinocencio-solvd")
    public void testLoginModal() {
        homePage = new AuthUtil().loginStandardUser();
        assertTrue(homePage.getNavBar().isUsernameDisplayed(), "Username should be displayed.");
    }

    @Test
    @TestPriority(Priority.P2)
    @MethodOwner(owner = "jinocencio-solvd")
    public void testLogout() {
        homePage = new AuthUtil().loginStandardUser();
        NavBar navBar = homePage.getNavBar();
        assertTrue(navBar.isLogoutButtonDisplayed(), "Logout should be displayed.");
        navBar.clickLogoutButton();
        assertTrue(navBar.isLoginButtonDisplayed(), "Login should be displayed.");
        assertFalse(navBar.isUsernameDisplayed(), "Username should not be displayed.");
    }

}
