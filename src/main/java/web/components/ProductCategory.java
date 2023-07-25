package web.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ProductCategory extends AbstractUIObject {

    public ProductCategory(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickCategoryButton() {
        getRootExtendedElement().click();
    }

    public String getCategoryTitle() {
        return getRootExtendedElement().getText();
    }

}
