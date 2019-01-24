package sample;

import com.intellij.codeInsight.hint.HintManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.VisualPosition;
import com.intellij.openapi.ui.Messages;

import static com.intellij.codeInsight.hint.HintManager.HIDE_BY_CARET_MOVE;
import static com.intellij.codeInsight.hint.HintManager.UNDER;

public class EditorAreaIllustration extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();

        LogicalPosition logicalPosition = caretModel.getLogicalPosition();
        VisualPosition visualPosition = caretModel.getVisualPosition();
        int offset = caretModel.getOffset();

        String message = logicalPosition.toString() + "\n" + visualPosition.toString() + "\n" +
                "Offset: " + offset;

//        Messages.showInfoMessage(message, "Caret Info");

        System.out.println(message);

//        HintManager.getInstance().showErrorHint(editor, "XXXXX", UNDER);
        HintManager.getInstance().showInformationHint(editor, "Tom here...");
    }
}
