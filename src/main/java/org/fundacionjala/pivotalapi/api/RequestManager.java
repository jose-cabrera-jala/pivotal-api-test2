package org.fundacionjala.pivotalapi.api;

import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 *Class that is going to be used to perform GET, POST, PUT and DELETE request.
 */
public final class RequestManager {

    public static final RequestSpecification REQUEST_SPECIFICATION = Connection.getInstance().getRequestSpecification();

    private RequestManager(){

    }

    /**
     * Method used to perform a GET request using and EndPoint.
     *
     * @param endPoint
     * @return Response from GET request
     */
    public static Response get(String endPoint) {
        return given().spec(REQUEST_SPECIFICATION)
                .when()
                .get(endPoint);
    }

    /**
     * Method used to perform a POST request using an EndPoint and Body required.
     *
     * @param endPoint
     * @param body
     * @return Response from POST request
     */
    public static Response post(String endPoint, String body) {
        return given().spec(REQUEST_SPECIFICATION)
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .post(endPoint);
    }

    /**
     * Method used to perform a POST request using an EndPoint and Body required.
     *
     * @param endPoint
     * @param body
     * @return Response from POST request
     */
    public static Response post(String endPoint, Map<String, Object> body) {
        return given().spec(REQUEST_SPECIFICATION)
                .params(body)
                .when()
                .post(endPoint);
    }

    /**
     * Method used to perform a PUT request using an EndPoint and Body required
     *
     * @param endPoint
     * @param body
     * @return Response from PUT request
     */
    public static Response put(String endPoint, String body) {
        return given().spec(REQUEST_SPECIFICATION)
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .put(endPoint);
    }

    /**
     * Method used to perform a PUT request using an EndPoint and Body required
     *
     * @param endPoint
     * @param body
     * @return Response from PUT request
     */
    public static Response put(String endPoint, Map<String, Object> body) {
        return given().spec(REQUEST_SPECIFICATION)
                .params(body)
                .when()
                .put(endPoint);
    }

    /**
     * Method used to perform a DELETE request using an EndPoint
     *
     * @param endPoint
     * @return Response from DELETE request
     */
    public static Response delete(String endPoint) {
        return given().spec(REQUEST_SPECIFICATION)
                .when()
                .delete(endPoint);
    }

}
