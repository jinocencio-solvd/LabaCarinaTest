package mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractCommonPage extends AbstractPage {

    protected final String unsupportedIosOperation = "Page operation not supported on ios";

    public AbstractCommonPage(WebDriver driver) {
        super(driver);
    }

}
