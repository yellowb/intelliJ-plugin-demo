package sample.configuration;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import com.intellij.util.xmlb.annotations.Attribute;
import com.intellij.util.xmlb.annotations.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "SampleTool",
        storages = {@Storage("SampleTool.xml")}
)
public class ToolConfiguration implements PersistentStateComponent<ToolConfiguration> {

    @Tag("port")
    private int port;

    @Tag("userName")
    private String userName;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Default constructor to make sure work with persistence framework
    public ToolConfiguration() {
        this.port = 0;
        this.userName = "";
    }

    @Nullable
    @Override
    public ToolConfiguration getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ToolConfiguration state) {
        System.out.println(this + " loadState");
        System.out.println(this + " income state " + printOut(state));

        XmlSerializerUtil.copyBean(state, this);
        if (this.port <= 0) {
            this.port = 10086;
        }
        if (this.userName == null || this.userName.length() == 0) {
            this.userName = "Tom123";
        }

        System.out.println(this + " this state " + printOut(this));
    }

    @Override
    public String toString() {
        return "[ToolConfiguration]";
    }

    public static String printOut(ToolConfiguration toolConfiguration) {
        return "port = " + toolConfiguration.getPort() + " , userName = " + toolConfiguration.getUserName();
    }
}
