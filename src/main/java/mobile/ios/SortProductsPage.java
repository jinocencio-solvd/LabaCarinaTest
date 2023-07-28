package mobile.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import mobile.common.ProductsPageBase;
import mobile.common.SortProductsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = SortProductsPageBase.class)
public class SortProductsPage extends SortProductsPageBase {

    public SortProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        throw new UnsupportedOperationException(UNSUPPORTED_IOS_OPERATION);
    }

    @Override
    public ProductsPageBase clickSortNameAtoZButton() {
        throw new UnsupportedOperationException(UNSUPPORTED_IOS_OPERATION);
    }

    @Override
    public ProductsPageBase clickSortNameZtoAButton() {
        throw new UnsupportedOperationException(UNSUPPORTED_IOS_OPERATION);
    }

    @Override
    public ProductsPageBase clickSortPriceLowToHighButton() {
        throw new UnsupportedOperationException(UNSUPPORTED_IOS_OPERATION);
    }

    @Override
    public ProductsPageBase clickSortPriceHighToLowButton() {
        throw new UnsupportedOperationException(UNSUPPORTED_IOS_OPERATION);
    }

}
