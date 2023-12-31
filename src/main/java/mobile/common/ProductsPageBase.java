package mobile.common;

import java.util.Map;
import org.openqa.selenium.WebDriver;

public abstract class ProductsPageBase extends AbstractCommonPage {

    protected ProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductPresent(String name);

    public abstract CartPageBase clickCartButton();

    public abstract Map<String, Double> getProductTitlePrices();

    public abstract int getCartCount();

    public abstract SortProductsPageBase clickSortButton();

    public abstract void addProductToCartByName(String name);

    public abstract Double getProductPrice(String productTitle);

}
