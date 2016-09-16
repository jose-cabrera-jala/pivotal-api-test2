package org.fundacionjala.pivotalapi.hooks;

import cucumber.api.java.After;
import org.fundacionjala.pivotalapi.api.RequestManager;

import static org.fundacionjala.pivotalapi.api.Mapper.RESPONSE_VALUES;

/**
 * The WorkspaceHook class delete a workspace, after being created
 *
 * @author  JuanaRodriguez on 9/16/2016.
 */
public class WorkspaceHook {
    private static final String WORKSPACE_ENDPOINT = "/my/workspaces/";
    private static final String WORKSPACE_1 = "Workspace1";
    private static final String WORKSPACE_ID = "id";

    @After("@deleteWorkspace")
    public void deleteWorkspace() {
        String id = RESPONSE_VALUES.get(WORKSPACE_1).jsonPath().get(WORKSPACE_ID).toString();
        RequestManager.delete(WORKSPACE_ENDPOINT + id);
    }
}
