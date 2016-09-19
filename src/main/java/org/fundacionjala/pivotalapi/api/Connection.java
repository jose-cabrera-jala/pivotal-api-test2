package org.fundacionjala.pivotalapi.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import org.fundacionjala.pivotalapi.util.Environment;

/**
 * Class that is used to make the connection.
 */
public final class Connection {
    private static final String TOKEN_HEADER = "X-TrackerToken";
    private static Connection instance;
    private RequestSpecification requestSpecification;


    /**
     * Constructor method to set a connection with Pivotal Tracker.
     */
    private Connection(){

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

    /**
     * Method applied to return only a Singleton instance.
     *
     * @return An instance
     */
    public static Connection getInstance(){
        if(instance == null){

            instance = new Connection();
        }
        return instance;
    }


    /**
     * Method that returns the Request specification.
     *
     * @return The request specification.
     */
    public  RequestSpecification getRequestSpecification(){

        return requestSpecification;
    }
}
