package mobile.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import mobile.common.CartPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-Cart Content']")
    private ExtendedWebElement cartContentContainer;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, '%s')]")
    private ExtendedWebElement productTitle;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpen() {
        return cartContentContainer.isElementPresent();
    }

    @Override
    public boolean isProductPresent(String name) {
        return swipe(productTitle.format(name), Direction.UP);
    }

}
