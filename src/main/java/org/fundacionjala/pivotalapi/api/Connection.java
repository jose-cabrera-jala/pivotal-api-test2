package org.fundacionjala.pivotalapi.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.fundacionjala.pivotalapi.util.Environment;

/**
 * Created by AngelaValdez on 8/31/2016.
 */
public class Connection {
    private static Connection instance;
    private RequestSpecification requestSpecification;

    private Connection(){
        Environment apiRetClient = Environment.getInstance();
        RestAssured.baseURI = apiRetClient.getBaseURI();
        RestAssured.proxy(apiRetClient.getProxy());
        RestAssured.basic(apiRetClient.getUser(), apiRetClient.getPassword());
        requestSpecification = new RequestSpecBuilder()
                .addHeader("X-TrackerToken", Environment.getInstance().getToken())
                .setRelaxedHTTPSValidation()
                .build();

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
