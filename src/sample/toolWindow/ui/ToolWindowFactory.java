package sample.toolWindow.ui;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ToolWindowFactory implements com.intellij.openapi.wm.ToolWindowFactory, DumbAware {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {

        ToolWindowForm toolWindowForm = new ToolWindowForm();
        JPanel toolWindowMainPanel = toolWindowForm.getMainPanel();

        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(toolWindowMainPanel, null, false);
        toolWindow.getContentManager().addContent(content);
    }
}
