package org.fundacionjala.pivotalapi.hooks;

import cucumber.api.java.After;
import io.restassured.response.Response;
import org.fundacionjala.pivotalapi.api.RequestManager;


import java.util.HashMap;

import static org.fundacionjala.pivotalapi.api.Mapper.RESPONSE_VALUES;


/**
 * Created by AngelaValdez on 9/15/2016.
 */
public class ProjectHook {

    private static final String PROJECTS_ENDPOINT = "/projects/";

    @After("@deleteProject")
    public void deleteProject() {
        getProjects().forEach((key,value) -> RequestManager.delete(PROJECTS_ENDPOINT + value.jsonPath().get("id").toString()));
    }

    public HashMap<String, Response> getProjects(){
       final String projectKey = "Project";
       return (HashMap<String, Response>) RESPONSE_VALUES.entrySet().stream().filter(value -> value.getKey().contains(projectKey));
    }
}
