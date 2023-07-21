package web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.components.ProductCard;
import web.components.ProductCategory;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[@id = 'login2']")
    private ExtendedWebElement loginNavButton;

    @FindBy(xpath = "//button[@id='next2']")
    private ExtendedWebElement nextButton;

    @FindBy(xpath = "//button[@id='prev2']")
    private ExtendedWebElement prevButton;

    @FindBy(xpath = "//*[@class='card-block']")
    private ExtendedWebElement cardLoadedMarker;

    @FindBy(xpath = "//a[@id='nameofuser']")
    private ExtendedWebElement nameOfUserNav;

    @FindBy(xpath = "//div[contains(@class, 'card ')]")
    private List<ProductCard> productList;

    @FindBy(xpath = "//a[@id = 'itemc']")
    private List<ProductCategory> categories;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(cardLoadedMarker);
    }

    public void clickLoginNavButton() {
        loginNavButton.click();
    }

    public void clickNextButton() throws InterruptedException {
        nextButton.click();
    }

    public void clickPrevButton() throws InterruptedException {
        prevButton.click();
    }

    public boolean isUsernameDisplayed() {
        waitForJSToLoad();
        return nameOfUserNav.isElementPresent();
    }


    public List<ProductCard> getProductList() {
        waitForJSToLoad();
        return productList;
    }

    public void clickCategoryByTitle(String title) {
        for (ProductCategory c : categories) {
            if (c.readTitle().equalsIgnoreCase(title)) {
                c.clickCategoryButton();
                waitForJSToLoad();
            }
        }
    }



}
