package org.fundacionjala.pivotalapi.util;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import static io.restassured.path.json.JsonPath.from;
import static org.fundacionjala.pivotalapi.api.RequestManager.delete;
import static org.fundacionjala.pivotalapi.api.RequestManager.get;
import static org.fundacionjala.pivotalapi.util.Constants.WORKSPACES_ENDPOINT;
import static org.fundacionjala.pivotalapi.util.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.pivotalapi.util.Constants.ID_ATTRIBUTE;

/**
 * Class that contains methods that are going to be used into the project.
 *
 * @author Jimmy Romero
 */
public final class CommonMethods {

    private static final Logger LOGGER = Logger.getLogger(CommonMethods.class.getName());

    private CommonMethods() {
    }

    /**
     * Method to clear all existent Projects in Pivotal Tracker.
     */
    public static void clearProjects() {
        List<Map<String, ?>> jsonAsArrayList = from(get(PROJECTS_ENDPOINT).asString()).get("");
        for (Map<String, ?> object : jsonAsArrayList) {
            delete(PROJECTS_ENDPOINT + object.get(ID_ATTRIBUTE).toString());
        }
    }

    /**
     * Method to clear all existent Workspaces in Pivotal Tracker.
     */
    public static void clearWorkspaces() {
        List<Map<String, ?>> jsonAsArrayList = from(get(WORKSPACES_ENDPOINT).asString()).get("");
        for (Map<String, ?> object : jsonAsArrayList) {
            delete(WORKSPACES_ENDPOINT + object.get(ID_ATTRIBUTE).toString());
        }
    }


    /**
     * Method to that is going to be used to quit the actual performing of the Project.
     *
     * @param message
     */
    public static void quitProgram(String message) {

        LOGGER.error(message);
    }
}
