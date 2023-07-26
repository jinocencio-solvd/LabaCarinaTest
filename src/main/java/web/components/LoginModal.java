package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginModal extends ModalBase {

    @FindBy(xpath = "//div[@class='modal fade show']//input[@id='loginusername']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//div[@class='modal fade show']//input[@id='loginpassword']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//div[@class='modal fade show']//button[@onclick='logIn()']")
    private ExtendedWebElement loginButton;

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return loginButton.isElementPresent();
    }

    public void typeUsername(String username) {
        usernameField.type(username);
    }

    public void typePassword(String password) {
        passwordField.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
