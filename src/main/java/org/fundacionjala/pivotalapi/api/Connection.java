package org.fundacionjala.pivotalapi.api;

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

    private Connection() {

        Environment apiRetClient = Environment.getInstance();
        RestAssured.baseURI = apiRetClient.getBaseURI();
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .addHeader(TOKEN_HEADER, apiRetClient.getToken())
                .build();
        if (!apiRetClient.getProxy().isEmpty()) {
            requestSpecification.proxy(apiRetClient.getProxy());
        }
    }

    public static Connection getInstance() {

        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    public RequestSpecification getRequestSpecification() {

        return requestSpecification;
    }
}
