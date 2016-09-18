package org.fundacionjala.pivotalapi.hooks;

import java.util.List;
import java.util.stream.Collectors;

import cucumber.api.java.After;

import org.fundacionjala.pivotalapi.api.RequestManager;

import static org.fundacionjala.pivotalapi.api.Mapper.RESPONSE_VALUES;
import static org.fundacionjala.pivotalapi.util.Constants.ID_ATTRIBUTE;
import static org.fundacionjala.pivotalapi.util.Constants.PROJECTS_ENDPOINT;


/**
 * Created by AngelaValdez on 9/15/2016.
 */
public class ProjectHook {

    private static final String PROJECT_KEY = "Project";

    @After("@deleteProject")
    public void deleteProject() {
        getProjects().forEach((e) -> RequestManager.delete(PROJECTS_ENDPOINT + RESPONSE_VALUES.get(e).jsonPath().get(ID_ATTRIBUTE).toString()));
    }

    public List<String> getProjects() {
        return RESPONSE_VALUES.keySet().stream().filter(value -> value.contains(PROJECT_KEY)).collect(Collectors.toList());
    }
}
