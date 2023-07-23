package web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.components.CartProduct;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//button[@data-target = '#orderModal']")
    private ExtendedWebElement placeOrderButton;

    @FindBy(xpath = "//tr[@class = 'success']")
    private List<CartProduct> productsInCart;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(placeOrderButton);
        waitForJSToLoad();
    }

    public List<CartProduct> getProductsInCart() {
        return productsInCart;
    }

}
