package mobile.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import mobile.common.CartPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase implements IMobileUtils {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpen() {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

    @Override
    public boolean isProductPresent(String name) {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

}
