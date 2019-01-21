package sample;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.VisualPosition;
import com.intellij.openapi.ui.Messages;

public class EditorAreaIllustration extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();

        LogicalPosition logicalPosition = caretModel.getLogicalPosition();
        VisualPosition visualPosition = caretModel.getVisualPosition();
        int offset = caretModel.getOffset();

        Messages.showInfoMessage(logicalPosition.toString() + "\n" + visualPosition.toString() + "\n" +
                "Offset: " + offset, "Caret Info");


    }
}
