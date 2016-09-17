package org.fundacionjala.pivotalapi.api;

import java.util.Map;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

/**
 * Created by AngelaValdez on 8/31/2016.
 */
public final class RequestManager {

    private static final Logger LOGGER = Logger.getLogger(RequestManager.class.getSimpleName());
    public static final RequestSpecification REQUEST_SPECIFICATION = Connection.getInstance().getRequestSpecification();

    private RequestManager() {

    }

    public static Response get(String endPoint) {
        LOGGER.info("GET endpoint is: " + endPoint);
        return given().spec(REQUEST_SPECIFICATION)
                .when()
                .get(endPoint);
    }

    public static Response post(String endPoint, String body) {
        LOGGER.info("POST endpoint is: " + endPoint);
        return given().spec(REQUEST_SPECIFICATION)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endPoint);
    }

    public static Response post(String endPoint, Map<String, Object> body) {
        LOGGER.info("POST endpoint is: " + endPoint);
        return given().spec(REQUEST_SPECIFICATION)
                .params(body)
                .when()
                .post(endPoint);
    }

    public static Response put(String endPoint, String body) {
        LOGGER.info("PUT endpoint is: " + endPoint);
        return given().spec(REQUEST_SPECIFICATION)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(endPoint);
    }

    public static Response put(String endPoint, Map<String, Object> body) {
        LOGGER.info("PUT endpoint is: " + endPoint);
        return given().spec(REQUEST_SPECIFICATION)
                .params(body)
                .when()
                .put(endPoint);
    }

    public static Response delete(String endPoint) {
        LOGGER.info("DELETE endpoint is: " + endPoint);
        return given().spec(REQUEST_SPECIFICATION)
                .when()
                .delete(endPoint);
    }

}
