package sample.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;

public class EditorIllustration extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {

        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        final Project project = e.getProject();

        final Document document = editor.getDocument();
        final SelectionModel selectionModel = editor.getSelectionModel();
        final int start = selectionModel.getSelectionStart();
        final int end = selectionModel.getSelectionEnd();
        final String selectedString = selectionModel.getSelectedText();

        System.out.println("start = " + start + " , end = " + end + " , selected = " + selectedString);

        WriteCommandAction.runWriteCommandAction(project, () -> {
            document.replaceString(start, end, "\n" + selectedString + "\n");
        });
        selectionModel.removeSelection();
    }

    @Override
    public void update(AnActionEvent e) {
        final Project project = e.getProject();
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        final SelectionModel selectionModel = editor.getSelectionModel();
        e.getPresentation().setVisible(project != null && editor != null && selectionModel.hasSelection());
    }
}
