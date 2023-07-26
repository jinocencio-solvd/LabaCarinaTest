package web;

import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
        assertTrue(cartPage.isProductDisplayed(productTitleToAdd),
            " Product title is not the same as displayed.");
    }

}
