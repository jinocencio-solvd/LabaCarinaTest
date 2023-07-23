package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.CartPage;

public class NavBar extends AbstractUIObject {

    @FindBy(xpath = "//a[@id = 'login2']")
    private ExtendedWebElement loginNavButton;

    @FindBy(xpath = "//a[@id = 'nameofuser']")
    private ExtendedWebElement nameOfUserNav;

    @FindBy(xpath = "//a[@id = 'cartur']")
    private ExtendedWebElement cartNavButton;

    @FindBy(xpath = "//a[@id = 'logout2']")
    private ExtendedWebElement logoutNavButton;

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public CartPage openCartPage() {
        cartNavButton.click();
        return new CartPage(driver);
    }

    public boolean isLoginNavButtonDisplayed() {
        return loginNavButton.isElementPresent(250L);
    }

    public LoginModal openLoginNavButton() {
        loginNavButton.click();
        return new LoginModal(driver);
    }

    public boolean isUsernameDisplayed() {
        return nameOfUserNav.isElementPresent();
    }

    public boolean isLogoutDisplayed() {
        return logoutNavButton.isElementPresent();
    }

    public void clickLogoutButton() {
        logoutNavButton.click();
    }

}
