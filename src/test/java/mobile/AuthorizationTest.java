package mobile;

import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import mobile.common.LoginPageBase;
import mobile.common.ProductsPageBase;
import org.testng.annotations.Test;

public class AuthorizationTest implements IAbstractTest {

    @Test
    public void testLogin() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        assertTrue(loginPage.isOpened(), "Login page is not opened");
        loginPage.typeUsername(R.TESTDATA.get("swagusername"));
        loginPage.typePassword(R.TESTDATA.get("swagpassword"));
        ProductsPageBase productsPage = loginPage.clickLoginButton();
        assertTrue(productsPage.isOpened(), "Product page is not opened");
    }

}
