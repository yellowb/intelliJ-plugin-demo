package sample.toolWindow;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import com.intellij.util.xmlb.annotations.XCollection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.intellij.util.xmlb.annotations.XCollection.Style.v2;

@State(
        name = "SubscribedServers",
        storages = {@Storage("SubscribedServers.xml")}
)
public class SubscribedServerList implements PersistentStateComponent<SubscribedServerList> {

    @XCollection(style = v2, propertyElementName = "subscribedServerList", elementTypes = {SubscribedServerItem.class})
    private List<SubscribedServerItem> subscribedServerList = new ArrayList<>();

    @Nullable
    @Override
    public SubscribedServerList getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull SubscribedServerList state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public void addServer(String serverUserName, String serverAddress, int serverPort, String password) {
        SubscribedServerItem server = new SubscribedServerItem(serverUserName, serverAddress, serverPort, password);
        subscribedServerList.add(server);
        System.out.println("[SubscribedServerList] add server = " + server);
    }

    public void removeServer(String serverAddress, int serverPort) {
        subscribedServerList.remove(new SubscribedServerItem(null, serverAddress, serverPort, null));
        System.out.println("[SubscribedServerList] remove server with address = " + serverAddress + ", port = " + serverPort);
    }

    public List<SubscribedServerItem> getAllServers() {
        return this.subscribedServerList;
    }

    @Override
    public String toString() {
        return "SubscribedServerList{" +
                "subscribedServerList=" + subscribedServerList +
                '}';
    }
}
