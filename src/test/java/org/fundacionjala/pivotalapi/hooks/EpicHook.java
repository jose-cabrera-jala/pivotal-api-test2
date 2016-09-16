package org.fundacionjala.pivotalapi.hooks;

import cucumber.api.java.After;
import org.fundacionjala.pivotalapi.api.RequestManager;

import static org.fundacionjala.pivotalapi.api.Mapper.RESPONSE_VALUES;
/**
 * Created by ErickaViraca on 9/16/2016.
 */
public class EpicHook {

    private static final String PROJECTS_ENDPOINT = "/projects/";
    private static final String EPICS_ENDPOINT = "/epics/";

    @After("@deleteEpic")
    public void deleteEpic() {
        String idEpic = RESPONSE_VALUES.get("Epic1").jsonPath().get("id").toString();
        String idProject = RESPONSE_VALUES.get("Project1").jsonPath().get("id").toString();
        RequestManager.delete(PROJECTS_ENDPOINT + idProject + EPICS_ENDPOINT + idEpic);
    }

}