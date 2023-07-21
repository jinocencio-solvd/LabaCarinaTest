package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class ModalBase extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-header']//button[@class='close']")
    private ExtendedWebElement headerCloseButton;

    @FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-footer']//button[@data-dismiss='modal']")
    private ExtendedWebElement footerCloseButton;

    public ModalBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isDisplayed();

}
