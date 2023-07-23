package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import java.util.Objects;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.ProductPage;

public class ProductCard extends AbstractUIObject {

    private final WebDriver driver;

    @FindBy(xpath = ".//a[contains(@class, 'hrefch')]")
    public ExtendedWebElement titleLink;

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        this.driver = driver;
    }

    public ProductPage openProductLink() {
        titleLink.click();
        return new ProductPage(driver);
    }

    public String readTitle() {
        return titleLink.getText();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductCard)) {
            return false;
        }
        ProductCard that = (ProductCard) o;
        return Objects.equals(titleLink.getText(), that.titleLink.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleLink.getText());
    }

}
