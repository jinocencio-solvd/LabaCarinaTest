package mobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import mobile.common.ProductsPageBase;
import mobile.common.SortProductsPageBase;
import org.testng.annotations.Test;

public class ProductsPageTest extends AbstractMobileTest {

    @Test
    @MethodOwner(owner = "jinocencio-solvd")
    public void testSortAtoZ() {
        ProductsPageBase productsPage = authUtils.loginStandard();
        SortProductsPageBase sortedProductsPage = productsPage.clickSortButton();
        assertTrue(sortedProductsPage.isOpened(), "Sort products page is not opened");
        productsPage = sortedProductsPage.clickSortNameAtoZButton();
        List<String> productTitles = new ArrayList<>(productsPage.getProductTitlePrices().keySet());
        List<String> sorted = List.copyOf(productTitles).stream()
            .sorted()
            .collect(Collectors.toList());
        assertEquals(productTitles, sorted,
            "The product titles are not in alphabetical order.");

    }

    @Test
    @MethodOwner(owner = "jinocencio-solvd")
    public void testSortZtoA() {
        ProductsPageBase productsPage = authUtils.loginStandard();
        SortProductsPageBase sortedProductsPage = productsPage.clickSortButton();
        assertTrue(sortedProductsPage.isOpened(), "Sort products page is not opened");
        productsPage = sortedProductsPage.clickSortNameZtoAButton();
        List<String> productTitles = new ArrayList<>(productsPage.getProductTitlePrices().keySet());
        List<String> reverseSorted = List.copyOf(productTitles).stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        assertEquals(productTitles, reverseSorted,
            "The product titles are not in reverse alphabetical order.");
    }

    @Test
    @MethodOwner(owner = "jinocencio-solvd")
    public void testSortPriceLowToHigh() {
        ProductsPageBase productsPage = authUtils.loginStandard();
        SortProductsPageBase sortedProductsPage = productsPage.clickSortButton();
        assertTrue(sortedProductsPage.isOpened(), "Sort products page is not opened");
        productsPage = sortedProductsPage.clickSortPriceLowToHighButton();
        List<Double> productPrices = new ArrayList<>(productsPage.getProductTitlePrices().values());
        List<Double> sortedPrices = List.copyOf(productPrices).stream()
            .sorted()
            .collect(Collectors.toList());
        assertEquals(productPrices, sortedPrices,
            "The product prices are not in low to high order.");
    }

    @Test
    @MethodOwner(owner = "jinocencio-solvd")
    public void testSortPriceHighToLow() {
        ProductsPageBase productsPage = authUtils.loginStandard();
        SortProductsPageBase sortedProductsPage = productsPage.clickSortButton();
        assertTrue(sortedProductsPage.isOpened(), "Sort products page is not opened");
        productsPage = sortedProductsPage.clickSortPriceHighToLowButton();
        List<Double> productPrices = new ArrayList<>(productsPage.getProductTitlePrices().values());
        List<Double> sortedPrices = List.copyOf(productPrices).stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        assertEquals(productPrices, sortedPrices,
            "The product prices are not in high to low order.");
    }

}