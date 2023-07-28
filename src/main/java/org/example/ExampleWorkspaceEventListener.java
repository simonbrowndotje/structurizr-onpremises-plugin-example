package org.example;

import com.structurizr.Workspace;
import com.structurizr.configuration.Role;
import com.structurizr.configuration.Visibility;
import com.structurizr.onpremises.component.workspace.WorkspaceEvent;
import com.structurizr.onpremises.component.workspace.WorkspaceEventListener;
import com.structurizr.util.WorkspaceUtils;

public class ExampleWorkspaceEventListener implements WorkspaceEventListener {

    @Override
    public void beforeSave(WorkspaceEvent event) {
        try {
            // convert the incoming JSON into a Workspace object
            // (this assumes the workspace is not client-side encrypted)
            String json = event.getJson();
            Workspace workspace = WorkspaceUtils.fromJson(json);

            // configure workspace access
            workspace.getConfiguration().clearUsers();
            workspace.getConfiguration().setVisibility(Visibility.Public);
            workspace.getConfiguration().addUser("user1@example.com", Role.ReadWrite);

            // re-serialize the Workspace object back to JSON, and override original version
            json = WorkspaceUtils.toJson(workspace, false);
            event.setJson(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}