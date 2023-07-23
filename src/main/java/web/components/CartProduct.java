package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartProduct extends AbstractUIObject {

    @FindBy(xpath = "./td[img]")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "./td[text()='%s']")
    private ExtendedWebElement cartProductTitle;

    public CartProduct(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getCartProductTitle(String productTitle) {
        return cartProductTitle.format(productTitle).getText();
    }

}
