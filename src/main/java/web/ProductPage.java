package web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.components.NavBar;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@onclick, 'addToCart')]")
    private ExtendedWebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(addToCartButton);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
        acceptAlert();
    }

    public NavBar getNavBar() {
        return new NavBar(driver);
    }

}
