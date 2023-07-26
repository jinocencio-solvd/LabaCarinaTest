package web;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.components.LoginModal;
import web.components.NavBar;
import web.utils.AuthUtil;

public class AuthenticationTest extends AbstractWebTest {

    @DataProvider(name = "StandardLogin")
    public Object[][] dataProviderProducts() {
        return new Object[][]{
            { R.TESTDATA.get("user"),  R.TESTDATA.get("password")},
        };
    }

    @Test(dataProvider = "StandardLogin")
    @MethodOwner(owner = "jinocencio-solvd")
    public void testLoginModal(String[] standardLogin) {
        LoginModal loginModal = homePage.openLoginModal();
        assertTrue(loginModal.isDisplayed(), "Login modal is not displayed");
        loginModal.typeUsername(standardLogin[0]);
        loginModal.typePassword(standardLogin[1]);
        loginModal.clickLoginButton();
        assertTrue(homePage.getNavBar().isUsernameDisplayed(), "Username is not displayed.");
        assertEquals(homePage.getNavBar().getUsername(), R.TESTDATA.get("user"),
            "The username does not match input username.");
    }

    @Test
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
