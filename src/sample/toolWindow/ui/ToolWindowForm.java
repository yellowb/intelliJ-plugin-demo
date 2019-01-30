package sample.toolWindow.ui;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.ui.Messages;
import sample.toolWindow.SubscribedServerList;

import javax.swing.*;

public class ToolWindowForm {
    private JPanel mainPanel;
    private JButton subscribeBtn;
    private JButton unsubscribeBtn;
    private JButton startBroadcastBtn;
    private JButton stopBroadcastBtn;
    private JList subscribedServerJList;
    private JList broadcastingServerJList;

    private final SubscribedServerList subscribedServerList = ServiceManager.getService(SubscribedServerList.class);

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public ToolWindowForm() {
        this.subscribeBtn.addActionListener(e -> subscribeNewServer());
    }

    /**
     * User input a new server's address and port
     */
    private void subscribeNewServer() {
        String input = Messages.showInputDialog("Input server's address and port, e.g. 192.168.1.2:9999", "Subscribe New Server", null);
        String[] tokens = input.split(":");
        subscribedServerList.addServer("", tokens[0], Integer.valueOf(tokens[1]), "");
        ((SubscribedServerUiList)this.subscribedServerJList).syncModel();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.subscribedServerJList = new SubscribedServerUiList();
    }
}
