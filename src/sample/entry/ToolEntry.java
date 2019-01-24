package sample.entry;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.ServiceManager;
import org.jetbrains.annotations.NotNull;
import sample.configuration.ToolConfiguration;

public class ToolEntry implements ApplicationComponent {

    private final ToolConfiguration toolConfiguration = ServiceManager.getService(ToolConfiguration.class);

    @Override
    public void initComponent() {
        System.out.println(this + "initComponent()");
        System.out.println(this + " " + ToolConfiguration.printOut(toolConfiguration));

        if (toolConfiguration.getPort() <= 0) {

            toolConfiguration.setPort(10086);
            toolConfiguration.setUserName("Tom123");
        }

    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return "SampleTool";
    }

    @Override
    public String toString() {
        return "[ToolEntry]";
    }
}
