package mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class SortProductsPageBase extends AbstractCommonPage {

    public SortProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductsPageBase clickSortNameAtoZButton();

    public abstract ProductsPageBase clickSortNameZtoAButton();

    public abstract ProductsPageBase clickSortPriceLowToHighButton();

    public abstract ProductsPageBase clickSortPriceHighToLowButton();

}
