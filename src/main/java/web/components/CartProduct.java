package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartProduct extends AbstractUIObject {

    @FindBy(xpath = "./td[img]")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "./td[contains(text(), '%s')]")
    private ExtendedWebElement cartProductTitleS;

    @FindBy(xpath = "./td[text()]")
    private ExtendedWebElement productTextData;

    public CartProduct(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isProductPresent(String productTitle) {
        return cartProductTitleS.format(productTitle).isPresent();
    }

}
