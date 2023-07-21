package web;

import static org.testng.Assert.assertEquals;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.components.ProductCard;
import web.components.ProductCategory;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='next2']")
    private ExtendedWebElement nextButton;

    @FindBy(xpath = "//*[@id='prev2']")
    private ExtendedWebElement prevButton;

    @FindBy(xpath = "//*[@class='card-block']")
    private ExtendedWebElement cardLoadedMarker;

    @FindBy(xpath = "//div[contains(@class, 'card ')]")
    private List<ProductCard> productList;

    @FindBy(xpath = "//a[@id = 'itemc']")
    private List<ProductCategory> categories;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(cardLoadedMarker);
    }

    public boolean isNextButtonDisplayed() {
        return nextButton.isElementPresent();
    }

    public void clickNextButton() throws InterruptedException {
        nextButton.click();
        waitForJSToLoad();
    }

    public void clickPrevButton() throws InterruptedException {
        prevButton.click();
        waitForJSToLoad();
    }

    public List<ProductCard> getProductList() {
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
