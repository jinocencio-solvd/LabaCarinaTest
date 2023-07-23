package web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.components.LoginModal;
import web.components.NavBar;
import web.components.ProductCard;
import web.components.ProductCategory;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//button[@id='next2']")
    private ExtendedWebElement nextButton;

    @FindBy(xpath = "//button[@id='prev2']")
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

    public void clickNextButton() {
        nextButton.click();
    }

    public void clickPrevButton() {
        prevButton.click();
    }

    public List<ProductCard> getDisplayedProducts() {
        waitForJSToLoad(250L);
        return new ArrayList<>(productList);
    }

    public LoginModal openLoginModal() {
        return new NavBar(driver).openLoginNavButton();
    }

    public NavBar getNavBar() {
        return new NavBar(driver);
    }

    public List<String> getDisplayedProductTitles() {
        return getDisplayedProducts().stream().map(ProductCard::readTitle)
            .collect(Collectors.toList());
    }

    public void clickCategoryByTitle(String title) {
        for (ProductCategory c : categories) {
            if (c.readTitle().equalsIgnoreCase(title)) {
                c.clickCategoryButton();
            }
        }
    }

    public ProductCard getProductCardByTitle(String title) {
        String xpath = String.format("//div[contains(@class, 'card ') and .//a[text()='%s']]",
            title);
        SearchContext sc = driver.findElement(By.xpath(xpath));
        return new ProductCard(driver, sc);
    }

//    public ProductPage openProductPageByName(String name){
//        return new ProductPage(driver).
//    }
}
