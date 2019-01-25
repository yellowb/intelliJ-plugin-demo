package sample.toolWindow.ui;

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
}
