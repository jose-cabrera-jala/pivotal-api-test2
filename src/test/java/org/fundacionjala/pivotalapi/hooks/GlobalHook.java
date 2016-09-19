package org.fundacionjala.pivotalapi.hooks;

import cucumber.api.java.Before;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.PropertyConfigurator;

import org.fundacionjala.pivotalapi.util.Environment;

import static org.fundacionjala.pivotalapi.api.RequestManager.get;
import static org.fundacionjala.pivotalapi.util.CommonMethods.clearProjects;
import static org.fundacionjala.pivotalapi.util.CommonMethods.clearWorkspaces;
import static org.fundacionjala.pivotalapi.util.CommonMethods.quitProgram;
import static org.fundacionjala.pivotalapi.util.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.pivotalapi.util.Constants.STATUS_CODE_SUCCESSFULLY;

/**
 * Class that contains methods that are going to be used to run the tests.
 *
 * @author Jimmy Romero
 */
public class GlobalHook {

    private static final String LOG4J_PROPERTIES = "src/main/resources/log4j.properties";

    private static final String PROPERTIES_FILE_UNFILLED = "Properties field cannot be read, it lacks one of the following: email, token or password";

    private static final String API_CREDENTIALS_INCORRECT = "The credentials are not right";

    private boolean beforeAllFlag = false;

    @Before
    public void beforeAll() {
        if (!beforeAllFlag) {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    clearProjects();
                    clearWorkspaces();
                }
            });
            if (StringUtils.isEmpty(Environment.getInstance().getToken())) {
                quitProgram(PROPERTIES_FILE_UNFILLED);
            } else if (get(PROJECTS_ENDPOINT).statusCode() != STATUS_CODE_SUCCESSFULLY) {
                quitProgram(API_CREDENTIALS_INCORRECT);
            }
            beforeAllFlag = true;
        }
        PropertyConfigurator.configure(LOG4J_PROPERTIES);
    }

    @Before("@ClearAllEnvironment")
    public void clearAllEnvironment() {
        clearProjects();
        clearWorkspaces();
    }
}
