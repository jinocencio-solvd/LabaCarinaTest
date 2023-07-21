package web.utils;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import web.HomePage;
import web.components.LoginModal;

public class AuthUtils implements ICustomTypePageFactory {

    public void login(String username, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginModal loginModal = new LoginModal(getDriver());
        if (!loginModal.isDisplayed()) {
            homePage.clickLoginNavButton();
        }
        loginModal.typeUsername(username);
        loginModal.typePassword(password);
        loginModal.clickLoginButton();
    }

    public void loginStandardUser() {
        login(R.TESTDATA.get("user"), R.TESTDATA.get("password"));
    }

}
