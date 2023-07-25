package web;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.components.CartProduct;
import web.components.NavBar;
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
    public void testAddToCart(String productTitleToAdd) {
        // Add product to cart
        ProductCard productCard = homePage.getProductCardByTitle(productTitleToAdd);
        ProductPage productPage = productCard.clickProductTitle();
        assertTrue(productPage.isPageOpened(), "Product page is not opened");
        productPage.clickAddToCartButton();

        // Navigate to cart page
        NavBar navBar = productPage.getNavBar();
        CartPage cartPage = navBar.clickCartPage();
        assertTrue(cartPage.isPageOpened(), "Cart page is not opened.");

        // Get added cart product and compare products by title
        List<CartProduct> cartProducts = cartPage.getProductsInCart();
        CartProduct addedCartProduct = null;
        for (CartProduct cartProduct : cartProducts) {
            // checks if productTitleToAdd is displayed in cart
            if (cartPage.isProductDisplayed(productTitleToAdd)) {
                addedCartProduct = cartProduct;
                break;
            }
        }
        assertNotNull(addedCartProduct, "Product is not displayed in the cart.");
    }

}
