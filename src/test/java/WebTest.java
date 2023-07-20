import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.HomePage;

public class WebTest implements IAbstractTest {

    private static WebDriver driver;
    private static HomePage homePage;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeCapabilities().getCapability("default");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = getDriver("default", options);

    }

    @BeforeMethod
    public void before() {
        homePage = new HomePage(driver);
        homePage.waitForJSToLoad();
        homePage.open();
    }

    @Test
    public void homePageTest() {
        assertTrue(homePage.isPageOpened());
        assertTrue(homePage.isNextButtonDisplayed());
    }

    @Test
    public void gridNavNextTest() throws InterruptedException {
        int numProductsBefore = homePage.getNumProductsDisplayed();
        homePage.clickNextButton();
        assertNotEquals(numProductsBefore, homePage.getNumProductsDisplayed(),
            "Number of products should not be the same");
    }

    @Test
    public void gridNavPrevTest() throws InterruptedException {
        int numProductsInit = homePage.getNumProductsDisplayed();
        homePage.clickNextButton();
        homePage.clickPrevButton();
        assertEquals(numProductsInit, homePage.getNumProductsDisplayed(),
            "Number of products should be the same");

    }

}
