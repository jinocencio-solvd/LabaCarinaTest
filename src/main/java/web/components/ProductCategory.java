package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ProductCategory extends AbstractUIObject {

//    public ExtendedWebElement categoryButton;

    public ProductCategory(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickCategoryButton() {
        getRootExtendedElement().click();
    }

    public String readTitle() {
        return  getRootExtendedElement().getText();
    }

}
