package sample.configuration.ui;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.options.BaseConfigurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sample.configuration.ToolConfiguration;

import javax.swing.*;

public class ToolConfigurationForm extends BaseConfigurable implements SearchableConfigurable {
    private JPanel mainPanel;
    private JTextField userNameField;
    private JTextField portField;

    private final ToolConfiguration toolConfiguration = ServiceManager.getService(ToolConfiguration.class);


    @NotNull
    @Override
    public String getId() {
        return "SampleToolConfiguration";
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "SampleTool";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return this.mainPanel;
    }

    @Override
    public void apply() throws ConfigurationException {
        toolConfiguration.setPort(Integer.parseInt(portField.getText()));
        toolConfiguration.setUserName(userNameField.getText());
    }

    @Override
    public boolean isModified() {
        if (toolConfiguration.getPort() != Integer.parseInt(portField.getText())) {
            return true;
        }
        if (toolConfiguration.getUserName() != userNameField.getText()) {
            return true;
        }
        return false;
    }

    @Override
    public void reset() {
        portField.setText(String.valueOf(toolConfiguration.getPort()));
        userNameField.setText(toolConfiguration.getUserName());
    }
}
