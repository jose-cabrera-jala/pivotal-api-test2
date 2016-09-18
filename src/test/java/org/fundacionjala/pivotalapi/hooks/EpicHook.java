package org.fundacionjala.pivotalapi.hooks;

import cucumber.api.java.After;
import org.fundacionjala.pivotalapi.api.RequestManager;

import static org.fundacionjala.pivotalapi.api.Mapper.RESPONSE_VALUES;
import static org.fundacionjala.pivotalapi.util.Constants.ID_ATTRIBUTE;
import static org.fundacionjala.pivotalapi.util.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.pivotalapi.util.Constants.EPICS_ENDPOINT;

/**
 * Created by ErickaViraca on 9/16/2016.
 */
public class EpicHook {


    @After("@deleteEpic")
    public void deleteEpic() {
        String idEpic = RESPONSE_VALUES.get("Epic1").jsonPath().get(ID_ATTRIBUTE).toString();
        String idProject = RESPONSE_VALUES.get("Project1").jsonPath().get(ID_ATTRIBUTE).toString();
        RequestManager.delete(PROJECTS_ENDPOINT + idProject + EPICS_ENDPOINT + idEpic);
    }

}