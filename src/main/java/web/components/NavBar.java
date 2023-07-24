package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.CartPage;

public class NavBar extends AbstractUIObject {

    @FindBy(xpath = "//a[@id = 'login2']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//a[@id = 'nameofuser']")
    private ExtendedWebElement nameOfUser;

    @FindBy(xpath = "//a[@id = 'cartur']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//a[@id = 'logout2']")
    private ExtendedWebElement logoutButton;

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public CartPage openCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isElementPresent();
    }

    public LoginModal clickLoginButton() {
        loginButton.click();
        return new LoginModal(driver);
    }

    public boolean isUsernameDisplayed() {
        return nameOfUser.isElementPresent();
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isElementPresent();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

}
