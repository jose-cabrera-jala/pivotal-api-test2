package org.fundacionjala.pivotalapi.api;

import com.github.markusbernhardt.proxy.ProxySearch;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.fundacionjala.pivotalapi.util.Environment;

/**
 * Created by AngelaValdez on 8/31/2016.
 */
public class Connection {
    private static final String TOKEN_HEADER = "X-TrackerToken";
    private static Connection instance;
    private RequestSpecification requestSpecification;

    private Connection(){
        Environment apiRetClient = Environment.getInstance();
        RestAssured.baseURI = apiRetClient.getBaseURI();
        if (ProxySearch.getDefaultProxySearch().getProxySelector() == null) {
            requestSpecification = new RequestSpecBuilder()
                    .setRelaxedHTTPSValidation()
                    .addHeader(TOKEN_HEADER, apiRetClient.getInstance().getToken())
                    .build();
        } else {
            requestSpecification = new RequestSpecBuilder()
                    .setRelaxedHTTPSValidation()
                    .setProxy(apiRetClient.getInstance().getProxy())
                    .addHeader(TOKEN_HEADER, apiRetClient.getInstance().getToken())
                    .build();
        }

    }
    public static Connection getInstance(){
        if(instance == null){
            instance = new Connection();
        }
        return instance;
    }

    public  RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }
}
