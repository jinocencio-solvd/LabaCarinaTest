import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;
import web.HomePage;

public class WebTest implements IAbstractTest {

    @Test
    public void homePageTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened());
    }

}
