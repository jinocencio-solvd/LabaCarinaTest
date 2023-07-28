package mobile.utils;

import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import mobile.common.LoginPageBase;
import mobile.common.ProductsPageBase;

public class MobileAuthUtils implements ICustomTypePageFactory {

    public ProductsPageBase login(String username, String password) {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        assertTrue(loginPage.isOpened(), "Login page is not opened");
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        return loginPage.clickLoginButton();
    }

    public ProductsPageBase loginStandard() {
        return login(R.TESTDATA.get("swagusername"), R.TESTDATA.get("swagpassword"));
    }

}
