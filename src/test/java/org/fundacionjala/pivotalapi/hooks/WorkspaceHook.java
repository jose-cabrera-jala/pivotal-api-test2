package org.fundacionjala.pivotalapi.hooks;

import cucumber.api.java.After;
import org.fundacionjala.pivotalapi.api.RequestManager;

import static org.fundacionjala.pivotalapi.api.Mapper.RESPONSE_VALUES;
import static org.fundacionjala.pivotalapi.util.Constants.WORKSPACES_ENDPOINT;
import static org.fundacionjala.pivotalapi.util.Constants.ID_ATTRIBUTE;

/**
 * The WorkspaceHook class delete a workspace, after being created
 *
 * @author  JuanaRodriguez on 9/16/2016.
 */
public class WorkspaceHook {
    private static final String WORKSPACE_1 = "Workspace1";

    @After("@deleteWorkspace")
    public void deleteWorkspace() {
        String id = RESPONSE_VALUES.get(WORKSPACE_1).jsonPath().get(ID_ATTRIBUTE).toString();
        RequestManager.delete(WORKSPACES_ENDPOINT + id);
    }
}
