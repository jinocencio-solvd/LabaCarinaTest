import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.HomePage;
import web.components.LoginModal;
import web.components.ProductCard;
import web.utils.AuthUtils;

public class WebTest implements IAbstractTest {

    private static WebDriver driver;
    private static HomePage homePage;
    private static AuthUtils authUtils;

    @BeforeClass
    public void setup() {
        authUtils = new AuthUtils();
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
    public void testHomePage() {
        assertTrue(homePage.isPageOpened());
    }

    @Test
    public void testProductNextPaginator() {
        List<ProductCard> initProductList = homePage.getProductList();
        homePage.clickNextButton();
        assertNotEquals(initProductList, homePage.getProductList(),
            "Products displayed should not be the same");
    }

    @Test
    public void testProductPrevPaginator() {
        List<ProductCard> initProductList = homePage.getProductList();
        homePage.clickNextButton();
        homePage.clickPrevButton();
        assertEquals(initProductList, homePage.getProductList(),
            "Products displayed should be the same");
    }

    @DataProvider(name = "CategoriesList")
    public Object[][] dataProviderCategories() {
        return new Object[][]{
            {"Phones", "Laptops", "Monitors"}
        };
    }

    @Test(dataProvider = "CategoriesList")
    public void testCategoryFilter(String[] categories) {
        Set<List<ProductCard>> productSet = new HashSet<>();
        for (String category : categories) {
            System.out.println(category);
            homePage.clickCategoryByTitle(category);
            productSet.add(new ArrayList<>(homePage.getProductList()));
        }
        assertEquals(productSet.size(), categories.length,
            "Each category should have a unique display of products");
    }

    @Test
    public void testLoginModal() {
        homePage.clickLoginNavButton();
        LoginModal loginModal = new LoginModal(driver);
        loginModal.isUIObjectPresent();
        loginModal.typeUsername(R.TESTDATA.get("user"));
        loginModal.typePassword(R.TESTDATA.get("password"));
        loginModal.clickLoginButton();
        assertTrue(homePage.isUsernameDisplayed(), "Username should be displayed.");
    }

    @Test
    public void testLogout() {
        authUtils.loginStandardUser();
        assertTrue(homePage.isLogoutDisplayed(), "Logout user should be displayed.");
        homePage.clickLogoutButton();
        assertTrue(homePage.isLoginNavButtonDisplayed(), "Login user should be displayed.");
        assertFalse(homePage.isUsernameDisplayed(), "Username should not be displayed.");
    }

}
