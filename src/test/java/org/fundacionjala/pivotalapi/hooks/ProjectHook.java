package org.fundacionjala.pivotalapi.hooks;

import cucumber.api.java.After;
import org.fundacionjala.pivotalapi.api.RequestManager;

import static org.fundacionjala.pivotalapi.api.Mapper.RESPONSE_VALUES;


/**
 * Created by AngelaValdez on 9/15/2016.
 */
public class ProjectHook {

    private static final String PROJECTS_ENDPOINT = "/projects/";

    @After("@deleteProject")
    public void deleteProject() {
        String id = RESPONSE_VALUES.get("Project1").jsonPath().get("id").toString();
        RequestManager.delete(PROJECTS_ENDPOINT + id);
    }
}
