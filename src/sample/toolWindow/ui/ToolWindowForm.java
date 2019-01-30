package sample.toolWindow.ui;

import com.intellij.ide.ui.EditorOptionsTopHitProvider;
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
    private JButton joinButton;

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
        if (input != null && input.length() > 0) {
            try {
                String[] tokens = input.split(":");
                subscribedServerList.addServer("", tokens[0], Integer.valueOf(tokens[1]), "");
                ((SubscribedServerUiList) this.subscribedServerJList).syncModel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.subscribedServerJList = new SubscribedServerUiList();
    }
}
