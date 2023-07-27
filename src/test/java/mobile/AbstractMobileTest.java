package mobile;

import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import mobile.common.LoginPageBase;
import mobile.common.ProductsPageBase;
import org.testng.annotations.BeforeMethod;

public class AbstractMobileTest implements IAbstractTest {

    protected ProductsPageBase productsPage;

    @BeforeMethod
    public void setup() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        assertTrue(loginPage.isOpen(), "Login page is not opened");
        loginPage.typeUsername(R.TESTDATA.get("swagusername"));
        loginPage.typePassword(R.TESTDATA.get("swagpassword"));
        productsPage = loginPage.clickLoginButton();
    }

}
