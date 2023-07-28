package mobile.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import mobile.common.CartPageBase;
import mobile.common.ProductsPageBase;
import mobile.common.SortProductsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    protected ExtendedWebElement productTitles;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']"
        + "/following-sibling::android.widget.TextView[@content-desc='test-Price']")
    protected ExtendedWebElement productPrice;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']")
    private ExtendedWebElement sortButton;

    @FindBy(xpath = "//android.widget.TextView["
        + "@content-desc='test-Item title' and @text='%s']"
        + "/following-sibling::android.view.ViewGroup[contains(@content-desc, 'test-ADD TO CART')]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']"
        + "/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement cartCount;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Terms of Service')]")
    private ExtendedWebElement termsOfService;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return sortButton.isElementPresent();
    }

    @Override
    public void addProductToCartByName(String name) {
        swipe(addToCartButton.format(name), MAX_SWIPES);
        addToCartButton.format(name).click();
    }

    @Override
    public boolean isProductPresent(String name) {
        return swipe(addToCartButton.format(name), MAX_SWIPES);
    }

    @Override
    public int getCartCount() {
        String strCount = cartCount.getText();
        return Integer.parseInt(strCount);
    }

    @Override
    public CartPageBase clickCartButton() {
        cartButton.click();
        return initPage(CartPageBase.class);
    }

    @Override
    public SortProductsPageBase clickSortButton() {
        sortButton.click();
        return initPage(SortProductsPageBase.class);
    }

    @Override
    public Map<String, Double> getProductTitlePrices() {
        Map<String, Double> titlePricesMap = new LinkedHashMap<>();
        boolean found = false;
        while (!found) {
            found = swipe(termsOfService, 1);
            List<String> productTitlesDisplayed = productTitles.formatToList().stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
            for (String productTitle : productTitlesDisplayed) {
                if (!titlePricesMap.containsKey(productTitle)) {
                    titlePricesMap.put(productTitle, getProductPrice(productTitle));
                }
            }
        }
        return titlePricesMap;
    }

    @Override
    public Double getProductPrice(String productTitle) {
        boolean found = false;
        while (!found) {
            found = swipe(productPrice.format(productTitle), 1);
        }
        String extractPrice = productPrice.format(productTitle).getText().replace("$", "");
        return Double.parseDouble(extractPrice);
    }

}
