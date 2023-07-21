import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.HomePage;
import web.components.LoginModal;
import web.components.ProductCategory;

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
    }

    @Test
    public void gridNavNextTest() throws InterruptedException {
        int numProductsBefore = homePage.getProductList().size();
        homePage.clickNextButton();
        assertNotEquals(numProductsBefore, homePage.getProductList().size(),
            "Number of products should not be the same");
    }

    @Test
    public void gridNavPrevTest() throws InterruptedException {
        int numProductsInit = homePage.getProductList().size();
        homePage.clickNextButton();
        homePage.clickPrevButton();
        assertEquals(numProductsInit, homePage.getProductList().size(),
            "Number of products should be the same");
    }

    @Test
    public void selectPhonesCategoryTest() {
        homePage.clickCategoryByTitle("Phones");
        assertEquals(homePage.getProductList().size(), 7);
    }

    @Test
    public void selectLaptopsCategoryTest() {
        homePage.clickCategoryByTitle("Laptops");
        assertEquals(homePage.getProductList().size(), 6);
    }

    @Test
    public void selectMonitorsCategoryTest() {
        homePage.clickCategoryByTitle("Monitors");
        assertEquals(homePage.getProductList().size(), 2);
    }

    @Test
    public void testLoginModal() {
        homePage.clickLoginNavButton();
        LoginModal loginModal = new LoginModal(driver);
        assertTrue(loginModal.isDisplayed());
        loginModal.typeUsername(R.TESTDATA.get("user"));
        loginModal.typePassword(R.TESTDATA.get("password"));
        loginModal.clickLoginButton();
        assertTrue(homePage.isUsernameDisplayed());
    }
}
