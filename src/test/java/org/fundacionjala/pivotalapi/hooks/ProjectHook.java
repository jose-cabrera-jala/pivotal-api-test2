package org.fundacionjala.pivotalapi.hooks;

import cucumber.api.java.After;
import org.fundacionjala.pivotalapi.api.RequestManager;

import java.util.List;
import java.util.stream.Collectors;

import static org.fundacionjala.pivotalapi.api.Mapper.RESPONSE_VALUES;


/**
 * Created by AngelaValdez on 9/15/2016.
 */
public class ProjectHook {

    private static final String PROJECTS_ENDPOINT = "/projects/";
    private static final String PROJECT_KEY = "Project";

    @After("@deleteProject")
    public void deleteProject() {
        getProjects().forEach((e) -> RequestManager.delete(PROJECTS_ENDPOINT + RESPONSE_VALUES.get(e).jsonPath().get("id").toString()));
    }

    public List<String> getProjects() {
        return RESPONSE_VALUES.keySet().stream().filter(value -> value.contains(PROJECT_KEY)).collect(Collectors.toList());
    }
}
