package org.fundacionjala.pivotalapi.stepsdefinitions;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by AngelaValdez on 9/15/2016.
 */
public class Assertions {
    private ResourcesSteps stepsDefinitions;

    public Assertions(ResourcesSteps stepsDefinitions) {
        this.stepsDefinitions = stepsDefinitions;
    }

    @Then("^I expect Status code (\\d+)$")
    public void iExpectStatusCode(int statusCode) {
        assertEquals(statusCode, stepsDefinitions.getResponse().getStatusCode());
    }

    @Then("^The (.*) field should be equals to (.*)$")
    public void theNameFieldShouldBeEqualsToAngy(String fieldName,String expectedValue){
        assertEquals(expectedValue, stepsDefinitions.getResponse().path(fieldName));
    }

    @Then("^The (.*) field not should be equals to (.*)$")
    public void theNameFieldShouldNotBeEqualsToEpic(String fieldName,String expectedValue){
        assertEquals(expectedValue, stepsDefinitions.getResponse().path(fieldName));
    }

}
