package mobile;

import static org.testng.Assert.assertEquals;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils.Direction;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest extends AbstractMobileTest implements IAbstractTest {

    @DataProvider(name = "ProductsList")
    public Object[][] dataProviderProducts() {
        return new Object[][]{
            {"Sauce Labs Backpack"},
            {"Sauce Labs Backpack", "Sauce Labs Bike Light"},
            {"Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt"},
            {"Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Onesie"},
        };
    }

    @Test(dataProvider = "ProductsList")
    @MethodOwner(owner = "jinocencio-solvd")
    public void testCartCount(String[] productList) {
        for (int i = 0; i < productList.length; i++) {
            String productName = productList[i];
            ExtendedWebElement elem;
            boolean found = false;
            while(!found) {
                elem = productsPage.getAddToCartButtonByName(productName);
                found = productsPage.swipe(elem, Direction.UP);
            }
            productsPage.addProductToCartByName(productName);
            assertEquals(productsPage.getCartCount(), i ,"Cart count is incorrect");
        }
    }

}
