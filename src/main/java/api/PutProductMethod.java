package api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/products/1", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/products/put/req.json")
@ResponseTemplatePath(path = "api/products/put/res.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutProductMethod  extends AbstractApiMethodV2 {

    public PutProductMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }

}
