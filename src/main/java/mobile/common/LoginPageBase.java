package mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    protected final String unsupportedIosOperation = "Operation for this page is not supported on ios";
    protected final String unsupportedAndroidOperation = "Operation for this page is not supported on Android";

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeUsername(String username);

    public abstract void typePassword(String password);

    public abstract boolean isOpen();

}
