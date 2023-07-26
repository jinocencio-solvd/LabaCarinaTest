package mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductsPageBase extends AbstractPage {

    protected ProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpen();
}
