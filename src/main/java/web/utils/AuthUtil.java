package web.utils;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import web.HomePage;
import web.components.LoginModal;

public class AuthUtil implements ICustomTypePageFactory {

    public HomePage login(String username, String password) {
        HomePage homePage = new HomePage(getDriver());
        LoginModal loginModal = homePage.openLoginModal();
        loginModal.typeUsername(username);
        loginModal.typePassword(password);
        loginModal.clickLoginButton();
        return homePage;
    }

    public HomePage loginStandardUser() {
        return login(R.TESTDATA.get("user"), R.TESTDATA.get("password"));
    }

}
