package web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='next2']")
    private ExtendedWebElement nextButton;

    @FindBy(xpath = "//*[@id='prev2']")
    private ExtendedWebElement prevButton;

    @FindBy(xpath = "//*[@id='tbodyid']")
    private ExtendedWebElement productGrid;

    @FindBy(xpath = "//*[@class='card-block']")
    private ExtendedWebElement card;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(card);
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

    public int getNumProductsDisplayed() {
        return productGrid.findExtendedWebElements(
            By.className("card-block")).size();
    }


}
