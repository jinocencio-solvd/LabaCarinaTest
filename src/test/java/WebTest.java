import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.HomePage;

public class WebTest implements IAbstractTest {

    private WebDriver driver;

    @BeforeClass
    public void setup(){
        ChromeOptions options = new ChromeCapabilities().getCapability("default");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = getDriver("default", options);
    }

    @Test
    public void homePageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        assertTrue(homePage.isPageOpened());
    }

}
