package sample.toolWindow.ui;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBList;
import com.intellij.util.ui.JBUI;
import sample.toolWindow.SubscribedServerItem;
import sample.toolWindow.SubscribedServerList;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EventListener;
import java.util.List;

public class SubscribedServerUiList extends JBList<SubscribedServerItem> implements PropertyChangeListener, EventListener {

    private final SubscribedServerList subscribedServerList = ServiceManager.getService(SubscribedServerList.class);
    private final DefaultListModel<SubscribedServerItem> model = new DefaultListModel<>();

    public SubscribedServerUiList() {
        //TODO
        this.setModel(this.model);
        this.setCellRenderer(new SubscribedServerUiCellRenderer());
        this.addMouseListener(new SubscribedServerUiCellClickListener(this));
        this.syncModel();
    }

    @Override
    public ListModel<SubscribedServerItem> getModel() {
        return this.model;
    }

    /**
     * Sync the data to UI
     */
    private void syncModel() {
        this.model.removeAllElements();
        List<SubscribedServerItem> allServers = subscribedServerList.getAllServers();
        for (SubscribedServerItem server : allServers) {
            this.model.addElement(server);
            System.out.println(server);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.syncModel();
    }

    static class SubscribedServerUiCellRenderer extends JLabel implements ListCellRenderer<SubscribedServerItem> {

        @Override
        public Component getListCellRendererComponent(JList<? extends SubscribedServerItem> list, SubscribedServerItem value, int index, boolean isSelected, boolean cellHasFocus) {
            final Color foreground = list.getForeground();
            final Color background = list.getBackground();
            String message = "";
            this.setForeground(foreground);
            this.setBorder(JBUI.Borders.empty(2, 10));

            if (isSelected) {
                message = "<html> # " + value.getServerAddress() + ":" + value.getServerPort() + "</html>";
                setBackground(JBColor.ORANGE);
            } else {
                message = "<html>" + value.getServerAddress() + ":" + value.getServerPort() + "</html>";

                setBackground(background);
            }
            this.setText(message);

            return this;
        }
    }

    static class SubscribedServerUiCellClickListener implements MouseInputListener {

        private final SubscribedServerUiList subscribedServerUiList;

        public SubscribedServerUiCellClickListener(SubscribedServerUiList subscribedServerUiList) {
            this.subscribedServerUiList = subscribedServerUiList;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(subscribedServerUiList.getSelectedValue());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
