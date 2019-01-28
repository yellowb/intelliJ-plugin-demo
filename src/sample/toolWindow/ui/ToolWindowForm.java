package sample.toolWindow.ui;

import com.intellij.openapi.ui.Messages;

import javax.swing.*;

public class ToolWindowForm {
    private JPanel mainPanel;
    private JButton subscribeBtn;
    private JButton unsubscribeBtn;
    private JButton startBroadcastBtn;
    private JButton stopBroadcastBtn;
    private JList subscribedServerJList;
    private JList broadcastingServerJList;

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public ToolWindowForm() {
        this.subscribedServerJList = new SubscribedServerUiList();
        this.subscribeBtn.addActionListener(e -> subscribeNewServer());
    }

    /**
     * User input a new server's address and port
     */
    private void subscribeNewServer() {
        String input = Messages.showInputDialog("Input server's address and port, e.g. 192.168.1.2:9999", "Subscribe New Server", null);
        System.out.println(input);
    }

}
