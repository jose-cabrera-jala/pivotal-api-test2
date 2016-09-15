package org.fundacionjala.pivotalapi.stepsdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import org.fundacionjala.pivotalapi.api.RequestManager;

import java.util.Map;

import static org.fundacionjala.pivotalapi.api.Mapper.addResponse;
import static org.fundacionjala.pivotalapi.api.Mapper.mapEndpoint;
import static org.junit.Assert.assertEquals;

public class ResourcesSteps {

    Response response;

    @When("^I send a (.*) GET request$")
    public void i_send_a_project_GET_request(String endPoint) {
        response = RequestManager.get(endPoint);
    }

    @When("^I send a (.*) POST with the json$")
    public void i_send_a_POST_with_the_json2(String endPoint, String body) {
        response = RequestManager.post(mapEndpoint(endPoint),body);
    }

    @When("^I send a (.*) PUT with the json$")
    public void i_send_a_PUT_request_to_ProjectRequest_with_json(String endPoint, String body) {
        response = RequestManager.put(mapEndpoint(endPoint), body);
    }

    @And("^I store as a (.*)$")
    public void iStoreAs(String name) {
        addResponse(name, response);
    }

    @When("^I send a (.*) DELETE$")
    public void iSendADELETERequest(String endPoint) {
        response = RequestManager.delete(mapEndpoint(endPoint));
    }

    @When("^I send a (.*) POST request$")
    public void iSendAPOSTRequest(String endPoint,Map<String, Object> parameters) {
        response = RequestManager.post(mapEndpoint(endPoint), parameters);
    }

    @When("^I send a (.*) PUT request$")
    public void iSendAPUTRequest(String endPoint,Map<String, Object> parameters) {
        response = RequestManager.put(mapEndpoint(endPoint), parameters);
    }

    public Response getResponse() {
        return response;
    }
}

