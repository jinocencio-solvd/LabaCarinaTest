package web;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractWebTest implements IAbstractTest {

    protected HomePage homePage;

    @BeforeMethod
    public void before() {
        homePage = new HomePage(getDriver());
        homePage.open();
        homePage.waitForJSToLoad();
        homePage.assertPageOpened();
    }

}
