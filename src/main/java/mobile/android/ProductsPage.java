package mobile.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import mobile.common.LoginPageBase;
import mobile.common.ProductsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//android.widget.TextView["
        + "@content-desc='test-Item title' and @text='%s']"
        + "/following-sibling::android.view.ViewGroup[contains(@content-desc, 'test-ADD TO CART')]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']"
        + "/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement cartCount;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']")
    private ExtendedWebElement productTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpen() {
        return filterButton.isElementPresent();
    }

    public void addProductToCartByName(String name){
        addToCartButton.format(name).click();
    }

    public ExtendedWebElement getAddToCartButtonByName(String name){
        return addToCartButton.format(name);
    }

    public int getCartCount() {
        String strCount = cartCount.getText();
        return Integer.parseInt(strCount);
    }


}
