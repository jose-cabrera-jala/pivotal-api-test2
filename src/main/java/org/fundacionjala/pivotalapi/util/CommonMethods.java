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

public final class CommonMethods {

    private static final Logger LOGGER = Logger.getLogger(CommonMethods.class.getName());

    private CommonMethods() {
    }

    public static void clearProjects() {
        List<Map<String, ?>> jsonAsArrayList = from(get(PROJECTS_ENDPOINT).asString()).get("");
        for (Map<String, ?> object : jsonAsArrayList) {
            delete(PROJECTS_ENDPOINT + object.get(ID_ATTRIBUTE).toString());
        }
    }

    public static void clearWorkspaces() {
        List<Map<String, ?>> jsonAsArrayList = from(get(WORKSPACES_ENDPOINT).asString()).get("");
        for (Map<String, ?> object : jsonAsArrayList) {
            delete(WORKSPACES_ENDPOINT + object.get(ID_ATTRIBUTE).toString());
        }
    }

    public static void quitProgram(final String message) {
        LOGGER.error(message);
    }
}
