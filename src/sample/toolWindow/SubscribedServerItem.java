package sample.toolWindow;

import com.intellij.util.xmlb.annotations.Tag;

public class SubscribedServerItem {

    @Tag("serverUserName")
    private String serverUserName;

    @Tag("serverAddress")
    private String serverAddress;

    @Tag("serverPort")
    private int serverPort;

    // Default constructor to make sure work with persistence framework
    public SubscribedServerItem() {
        this("", "", 0);
    }

    public SubscribedServerItem(String serverUserName, String serverAddress, int serverPort) {
        this.serverUserName = serverUserName;
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public String getServerUserName() {
        return serverUserName;
    }

    public void setServerUserName(String serverUserName) {
        this.serverUserName = serverUserName;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }
}
