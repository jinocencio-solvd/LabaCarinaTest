import static org.testng.Assert.assertEquals;

import api.DeleteProductMethod;
import api.GetAllProductsMethod;
import api.GetOneProductMethod;
import api.PostProductMethod;
import api.PutProductMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import java.lang.invoke.MethodHandles;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "jinocencio-solvd")
    public void testGetOneProduct() {
        GetOneProductMethod api = new GetOneProductMethod();
        api.setProperties("api/products/product.properties");
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/products/get_one/res.schema");
    }

    @Test()
    @MethodOwner(owner = "jinocencio-solvd")
    public void testGetAllProducts() {
        GetAllProductsMethod api = new GetAllProductsMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/products/get/res.schema");
    }

    @Test()
    @MethodOwner(owner = "jinocencio-solvd")
    public void testPostProductsWithProperties() {
        PostProductMethod api = new PostProductMethod();
        api.setProperties("api/products/product.properties");
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test()
    @MethodOwner(owner = "jinocencio-solvd")
    public void testPostProductContent() {
        PostProductMethod api = new PostProductMethod();
        api.setProperties("api/products/product.properties");
        Response res = api.callAPI();
        String expectedTitle = res.jsonPath().getString("title");
        assertEquals(expectedTitle, "Apple Vision Pro", "The product title does not match");
        String expectedPrice = res.jsonPath().getString("price");
        assertEquals(expectedPrice, "3499", "The product price does not match");
    }

    @Test()
    @MethodOwner(owner = "jinocencio-solvd")
    public void testPostProductsWithPropertiesMissingField() {
        PostProductMethod api = new PostProductMethod();
        api.setProperties("api/products/product.properties");
        api.removeProperty("description");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "jinocencio-solvd")
    public void testPutProducts() {
        PutProductMethod api = new PutProductMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());

    }

    @Test()
    @MethodOwner(owner = "jinocencio-solvd")
    public void testDeleteProducts() {
        DeleteProductMethod api = new DeleteProductMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

}
