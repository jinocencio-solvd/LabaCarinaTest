package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.ProductPage;

public class ProductCard extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(@class, 'hrefch')]")
    public ExtendedWebElement titleLink;

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductPage clickProductTitle() {
        titleLink.click();
        return new ProductPage(driver);
    }

    public String getProductTitle() {
        return titleLink.getText();
    }

}
