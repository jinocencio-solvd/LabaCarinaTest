package mobile;

import static org.testng.Assert.assertEquals;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest extends AbstractMobileTest implements IAbstractTest {

    @DataProvider(name = "ProductsList")
    public Object[][] dataProviderProducts() {
        return new Object[][]{
            {"Sauce Labs Backpack"},
            {"Sauce Labs Backpack", "Sauce Labs Bike Light"},
        };
    }

    @Test(dataProvider = "ProductsList")
    @MethodOwner(owner = "jinocencio-solvd")
    public void testCartCount(String[] productList) {
        for (String productName : productList) {
            productsPage.addProductToCartByName(productName);
        }
        assertEquals(productsPage.getCartCount(), productList.length, "Cart count is incorrect");
    }

}
