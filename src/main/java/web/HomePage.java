package web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.components.LoginModal;
import web.components.NavBar;
import web.components.ProductCard;
import web.components.ProductCategory;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//button[@id='next2']")
    private ExtendedWebElement nextPageButton;

    @FindBy(xpath = "//button[@id='prev2']")
    private ExtendedWebElement prevPageButton;

    @FindBy(xpath = "//*[@class='card-block']")
    private ExtendedWebElement cardLoadedMarker;

    @FindBy(xpath = "//div[contains(@class, 'card ')]")
    private List<ProductCard> productList;

    @FindBy(xpath = "//a[@id = 'itemc']")
    private List<ProductCategory> categories;

    @FindBy(xpath = "//div[contains(@class, 'card ')]")
    private List<ProductCard> productCards;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(cardLoadedMarker);
    }

    public void clickNextPageButton() {
        nextPageButton.click();
    }

    public void clickPrevPageButton() {
        prevPageButton.click();
    }

    public List<ProductCard> getDisplayedProducts() {
        waitForJSToLoad(250L);
        return new ArrayList<>(productList);
    }

    public LoginModal openLoginModal() {
        return new NavBar(driver).clickLoginButton();
    }

    public NavBar getNavBar() {
        return new NavBar(driver);
    }

    public List<String> getDisplayedProductTitles() {
        return getDisplayedProducts().stream().map(ProductCard::getProductTitle)
            .collect(Collectors.toList());
    }

    public void clickCategoryByTitle(String title) {
        for (ProductCategory c : categories) {
            if (c.getCategoryTitle().equalsIgnoreCase(title)) {
                c.clickCategoryButton();
            }
        }
    }

    public ProductCard getProductCardByTitle(String title) {
        return productCards.stream()
            .filter(p -> p.getProductTitle().equals(title))
            .findFirst()
            .orElse(null);
    }

}
