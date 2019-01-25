package sample.toolWindow;

import com.intellij.util.xmlb.annotations.Tag;

import java.util.Objects;

public class SubscribedServerItem {

    @Tag("serverUserName")
    private String serverUserName;

    @Tag("serverAddress")
    private String serverAddress;

    @Tag("serverPort")
    private int serverPort;

    @Tag("password")
    private String password;

    // Default constructor to make sure work with persistence framework
    public SubscribedServerItem() {
        this("", "", 0, "");
    }

    public SubscribedServerItem(String serverUserName, String serverAddress, int serverPort, String password) {
        this.serverUserName = serverUserName;
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscribedServerItem that = (SubscribedServerItem) o;
        return serverPort == that.serverPort &&
                Objects.equals(serverAddress, that.serverAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serverAddress, serverPort);
    }

    @Override
    public String toString() {
        return "SubscribedServerItem{" +
                "serverUserName='" + serverUserName + '\'' +
                ", serverAddress='" + serverAddress + '\'' +
                ", serverPort=" + serverPort +
                ", password='" + password + '\'' +
                '}';
    }
}
