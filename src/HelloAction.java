import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

public class HelloAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getData(PlatformDataKeys.PROJECT);
        String name = Messages.showInputDialog(project, "What is your name?", "Input your name", Messages.getQuestionIcon());
        System.out.println("User input: " + name);
        Messages.showMessageDialog(project, "Hello~~, " + name + "!\n I am glad to see you.", "Information", Messages.getInformationIcon());
    }
}
