package mobile.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import mobile.common.LoginPageBase;
import mobile.common.ProductsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeUsername(String username) {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

    @Override
    public void typePassword(String password) {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

    @Override
    public boolean isOpen() {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

    @Override
    public ProductsPageBase clickLoginButton() {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

}
