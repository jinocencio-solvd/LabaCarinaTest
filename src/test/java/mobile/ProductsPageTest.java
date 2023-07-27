package mobile;

import static org.testng.Assert.assertEquals;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import mobile.common.SortProductsPageBase;
import org.testng.annotations.Test;

public class ProductsPageTest extends AbstractMobileTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "jinocencio-solvd")
    public void testSortAtoZ() {
        SortProductsPageBase sortedProductsPage = productsPage.clickSortButton();
        productsPage = sortedProductsPage.clickSortNameAtoZButton();
        List<String> productTitles = productsPage.getProductTitlePrices().keySet().stream()
            .toList();
        List<String> sorted = List.copyOf(productTitles).stream()
            .sorted()
            .collect(Collectors.toList());
        assertEquals(productTitles, sorted,
            "The product titles are not in alphabetical order.");

    }

    @Test
    @MethodOwner(owner = "jinocencio-solvd")
    public void testSortZtoA() {
        SortProductsPageBase sortedProductsPage = productsPage.clickSortButton();
        productsPage = sortedProductsPage.clickSortNameZtoAButton();
        List<String> productTitles = productsPage.getProductTitlePrices().keySet().stream()
            .toList();
        List<String> reverseSorted = List.copyOf(productTitles).stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        assertEquals(productTitles, reverseSorted,
            "The product titles are not in reverse alphabetical order.");
    }

    @Test
    @MethodOwner(owner = "jinocencio-solvd")
    public void testSortPriceLowToHigh() {
        SortProductsPageBase sortedProductsPage = productsPage.clickSortButton();
        productsPage = sortedProductsPage.clickSortPriceLowToHighButton();
        List<Double> productPrices = productsPage.getProductTitlePrices().values().stream()
            .toList();
        List<Double> sortedPrices = List.copyOf(productPrices).stream()
            .sorted()
            .collect(Collectors.toList());
        assertEquals(productPrices, sortedPrices,
            "The product prices are not in low to high order.");
    }

    @Test
    @MethodOwner(owner = "jinocencio-solvd")
    public void testSortPriceHighToLow() {
        SortProductsPageBase sortedProductsPage = productsPage.clickSortButton();
        productsPage = sortedProductsPage.clickSortPriceHighToLowButton();
        List<Double> productPrices = productsPage.getProductTitlePrices().values().stream()
            .toList();
        List<Double> sortedPrices = List.copyOf(productPrices).stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        assertEquals(productPrices, sortedPrices,
            "The product prices are not in high to low order.");
    }

}
