package sample.toolWindow;

import java.util.LinkedList;
import java.util.List;

public class BroadcastingServer {

    private String serverUserName;

    private int port;

    private List<Subscriber> subscribers;

    public BroadcastingServer() {
        this("", 0);
    }

    public BroadcastingServer(String serverUserName, int port) {
        this.serverUserName = serverUserName;
        this.port = port;
        this.subscribers = new LinkedList<>();
    }

    public String getServerUserName() {
        return serverUserName;
    }

    public void setServerUserName(String serverUserName) {
        this.serverUserName = serverUserName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public int getSubscriberCount() {
        return this.subscribers.size();
    }

    public void addSubscriber(String userName) {
        Subscriber subscriber = new Subscriber(userName);
        this.subscribers.add(subscriber);
    }

    public void removeSubscriber(String userName) {
        this.subscribers.remove(new Subscriber(userName));
    }
}
