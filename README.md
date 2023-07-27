# Structurizr on-premises plugin example

This Java project shows an example of how to build a plugin for the Structurizr on-premises installation.
A plugin is an implementation of the `com.structurizr.onpremises.plugin.WorkspaceEventListener` interface,
with the `beforeSave()` method being called before the workspace is saved.
See [ExampleWorkspaceEventListener.java](src/main/java/org/example/ExampleWorkspaceEventListener.java) for an example.

## Building the plugin

```
./gradlew clean build
```

(tested with Java 17)

## Deploying the plugin

- Create a `plugins` directory in your Structurizr data directory. 
- Copy the `build/libs/example-plugin-1.0.0.jar` file to `$STRUCTURIZR_DATA_DIRECTORY/plugins/`.
- Modify your `structurizr.properties` file to include the following line: `structurizr.plugin.workspaceEventListener=org.example.ExampleWorkspaceEventListener`
- Restart your on-premises installation. 