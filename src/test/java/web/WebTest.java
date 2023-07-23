package web;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.components.ProductCard;

public class WebTest extends AbstractWebTest {

    @Test
    @TestPriority(Priority.P1)
    @MethodOwner(owner = "jinocencio-solvd")
    public void testHomePage() {
        assertTrue(homePage.isPageOpened());
    }

    @Test
    @TestPriority(Priority.P2)
    @MethodOwner(owner = "jinocencio-solvd")
    public void testProductNextPaginator() {
        int initDisplayedProductsSize = homePage.getDisplayedProducts().size();
        homePage.clickNextButton();
        assertNotEquals(initDisplayedProductsSize, homePage.getDisplayedProducts().size(),
            "Product titles displayed should not be the same");
    }

    @Test
    @TestPriority(Priority.P3)
    @MethodOwner(owner = "jinocencio-solvd")
    public void testProductPrevPaginator() {
        int initDisplayedProductsSize = homePage.getDisplayedProducts().size();
        homePage.clickNextButton();
        assertNotEquals(initDisplayedProductsSize, homePage.getDisplayedProducts().size());
        homePage.clickPrevButton();
        assertEquals(initDisplayedProductsSize, homePage.getDisplayedProducts().size());
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
            productSet.add(new ArrayList<>(homePage.getDisplayedProducts()));
        }
        assertEquals(productSet.size(), categories.length,
            "Each category should have a unique display of products");
    }

}
