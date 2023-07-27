package mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractCommonPage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpen();

    public abstract boolean isProductPresent(String name);

}
