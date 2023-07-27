package mobile.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import java.util.Map;
import mobile.common.CartPageBase;
import mobile.common.ProductsPageBase;
import mobile.common.SortProductsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase implements IMobileUtils {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpen() {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

    @Override
    public void addProductToCartByName(String name) {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

    @Override
    public boolean isProductPresent(String name) {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

    @Override
    public int getCartCount() {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

    @Override
    public CartPageBase clickCartButton() {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

    @Override
    public SortProductsPageBase clickSortButton() {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

    @Override
    public Map<String, Double> getProductTitlePrices() {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

    @Override
    public Double getProductPrice(String productTitle) {
        throw new UnsupportedOperationException(unsupportedIosOperation);
    }

}
