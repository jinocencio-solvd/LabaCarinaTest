package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartProduct extends AbstractUIObject {

    @FindBy(xpath = "./td[1]") // no attrs in element
    private ExtendedWebElement productImage;

    @FindBy(xpath = "./td[2]") // no attrs in element
    private ExtendedWebElement productTitle;

    public CartProduct(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getCartProductTitle() {
        return productTitle.getText();
    }

}
