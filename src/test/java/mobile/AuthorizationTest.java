package mobile;

import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import mobile.android.LoginPage;
import mobile.android.ProductsPage;
import org.testng.annotations.Test;

public class AuthorizationTest implements IAbstractTest {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        assertTrue(loginPage.isOpen(), "Login page is not opened");
        loginPage.typeUsername(R.TESTDATA.get("swagusername"));
        loginPage.typePassword(R.TESTDATA.get("swagpassword"));
        ProductsPage productsPage = loginPage.clickLoginButton();
        assertTrue(productsPage.isOpen(), "Product page is not opened");
    }

}
