package web;

import static org.testng.Assert.assertEquals;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.components.ProductCard;

public class CartTest extends AbstractWebTest {

    @DataProvider(name = "ProductsList")
    public Object[][] dataProviderProducts() {
        return new Object[][]{
            {"Samsung galaxy s6"},
            {"Nokia lumia 1520"},
            {"Sony vaio i5"},
        };
    }

    @Test(dataProvider = "ProductsList")
    @TestPriority(Priority.P1)
    @MethodOwner(owner = "jinocencio-solvd")
    public void testProductCard(String productTitle) {
        ProductCard pc = homePage.getProductCardByTitle(productTitle);
        ProductPage productPage = pc.openProductLink();
        productPage.clickAddToCartButton();
        CartPage cartPage = productPage.getNavBar().openCartPage();
        String cartProductTitle = cartPage.getProductsInCart().get(0).getCartProductTitle();
        assertEquals(cartProductTitle, productTitle);
    }

}
