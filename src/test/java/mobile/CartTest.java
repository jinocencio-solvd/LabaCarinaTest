package mobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import mobile.common.CartPageBase;
import mobile.common.ProductsPageBase;
import mobile.utils.MobileAuthUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest implements IAbstractTest {

    @DataProvider(name = "ProductNamesArray")
    public Object[][] dataProviderProducts() {
        return new Object[][]{
            {"Sauce Labs Backpack"},
            {"Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt"},
            {"Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Onesie"},
        };
    }

    @Test(dataProvider = "ProductNamesArray")
    @MethodOwner(owner = "jinocencio-solvd")
    public void testCartCount(String[] productNamesArray) {
        ProductsPageBase productsPage = new MobileAuthUtils().loginStandard();
        for (String productName : productNamesArray) {
            assertTrue(productsPage.isProductPresent(productName), "Product was not found.");
            productsPage.addProductToCartByName(productName);
        }
        assertEquals(productsPage.getCartCount(), productNamesArray.length,
            "Cart count is incorrect");
    }

    @Test(dataProvider = "ProductNamesArray")
    @MethodOwner(owner = "jinocencio-solvd")
    public void testCartHasProducts(String[] productNamesArray) {
        ProductsPageBase productsPage = new MobileAuthUtils().loginStandard();
        for (String productName : productNamesArray) {
            productsPage.addProductToCartByName(productName);
        }

        CartPageBase cartPage = productsPage.clickCartButton();
        assertTrue(cartPage.isOpened(), "Cart page is not open");

        for (String productName : productNamesArray) {
            assertTrue(cartPage.isProductPresent(productName));
        }
    }

}
