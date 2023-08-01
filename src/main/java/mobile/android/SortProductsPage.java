package mobile.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import mobile.common.ProductsPageBase;
import mobile.common.SortProductsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = SortProductsPageBase.class)
public class SortProductsPage extends SortProductsPageBase {

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Name (A to Z)')]")
    private ExtendedWebElement sortNameAtoZButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Name (Z to A)')]")
    private ExtendedWebElement sortNameZtoAButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Price (low to high)')]")
    private ExtendedWebElement sortPriceLowToHighButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Price (high to low)')]")
    private ExtendedWebElement sortPriceHighToLowButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Cancel')]")
    private ExtendedWebElement cancelButton;

    public SortProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return cancelButton.isElementPresent();
    }

    @Override
    public ProductsPageBase clickSortNameAtoZButton() {
        sortNameAtoZButton.click();
        return initPage(ProductsPageBase.class);
    }

    @Override
    public ProductsPageBase clickSortNameZtoAButton() {
        sortNameZtoAButton.click();
        return initPage(ProductsPageBase.class);
    }

    @Override
    public ProductsPageBase clickSortPriceLowToHighButton() {
        sortPriceLowToHighButton.click();
        return initPage(ProductsPageBase.class);
    }

    @Override
    public ProductsPageBase clickSortPriceHighToLowButton() {
        sortPriceHighToLowButton.click();
        return initPage(ProductsPageBase.class);
    }

}
