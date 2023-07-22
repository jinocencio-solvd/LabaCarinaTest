package web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import web.components.LoginModal;
import web.components.NavBar;

public abstract class AbstractWebTest implements IAbstractTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void before() {
        ChromeOptions options = new ChromeCapabilities().getCapability("default");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = getDriver("default", options);
        homePage = new HomePage(driver);
        homePage.open();
        homePage.waitForJSToLoad();
    }

}
