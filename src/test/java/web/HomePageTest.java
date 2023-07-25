package web;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.components.ProductCard;

public class HomePageTest extends AbstractWebTest {

    @Test
    @TestPriority(Priority.P1)
    @MethodOwner(owner = "jinocencio-solvd")
    public void testHomePage() {
        assertTrue(homePage.isPageOpened(), "The home page is not opened.");
    }

    @Test
    @TestPriority(Priority.P2)
    @MethodOwner(owner = "jinocencio-solvd")
    public void testProductNextPaginator() {
        int initDisplayedProductsSize = homePage.getDisplayedProducts().size();
        homePage.clickNextPageButton();
        assertNotEquals(initDisplayedProductsSize, homePage.getDisplayedProducts().size(),
            "Product titles displayed should not be the same");
    }

    @Test
    @TestPriority(Priority.P3)
    @MethodOwner(owner = "jinocencio-solvd")
    public void testProductPrevPaginator() {
        int initDisplayedProductsSize = homePage.getDisplayedProducts().size();
        homePage.clickNextPageButton();
        assertNotEquals(initDisplayedProductsSize, homePage.getDisplayedProducts().size(),
            "Page 2 should have a different number of products displayed.");
        homePage.clickPrevPageButton();
        assertEquals(initDisplayedProductsSize, homePage.getDisplayedProducts().size(),
            "Page 1 should have the same number of products displayed.");
    }

    @DataProvider(name = "CategoriesList")
    public Object[][] dataProviderCategories() {
        return new Object[][]{
            {"Phones", "Laptops", "Monitors"}
        };
    }

    @Test(dataProvider = "CategoriesList")
    @TestPriority(Priority.P4)
    @MethodOwner(owner = "jinocencio-solvd")
    public void testCategoryFilter(String[] categories) {
        Set<List<ProductCard>> productSet = new HashSet<>();
        for (String category : categories) {
            homePage.clickCategoryByTitle(category);
            productSet.add(homePage.getDisplayedProducts());
        }
        assertEquals(productSet.size(), categories.length,
            "Each category should have a unique display of products");
    }

}
