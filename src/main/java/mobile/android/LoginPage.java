package mobile.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import mobile.common.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.ProductPage;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeUsername(String username) {
        usernameField.type(username);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }

    @Override
    public boolean isOpen() {
        return loginButton.isElementPresent();
    }

    public ProductsPage clickLoginButton(){
        loginButton.click();
        return new ProductsPage(getDriver());
    }
}
