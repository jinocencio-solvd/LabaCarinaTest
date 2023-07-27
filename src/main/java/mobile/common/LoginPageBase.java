package mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractCommonPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeUsername(String username);

    public abstract void typePassword(String password);

    public abstract boolean isOpen();

    public abstract ProductsPageBase clickLoginButton();

}
