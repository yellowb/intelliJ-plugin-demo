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

    @Tag("Port")
    public int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Nullable
    @Override
    public ToolConfiguration getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ToolConfiguration state) {
        System.out.println(this + "loadState");
        System.out.println(this + " income state port = " + state.getPort());

        XmlSerializerUtil.copyBean(state, this);
        if (this.port <= 0) {
            this.port = 10086;
        }
        System.out.println(this + " this state port = " + this.port);
    }

    @Override
    public String toString() {
        return "[ToolConfiguration]";
    }
}
