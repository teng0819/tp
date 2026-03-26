package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL = "https://se-education.org/addressbook-level3/UserGuide.html";
    public static final String HELP_WINDOW_CONTENT = String.join("\n",
            "ManageUp Command Guide",
            "",
            "help",
            "  Shows this in-app help window.",
            "  Allowed input: no additional parameters.",
            "  Example: help",
            "",
            "add",
            "  Adds an employee.",
            "  Allowed input: n/NAME p/PHONE e/EMAIL d/DEPARTMENT pos/POSITION [t/TAG]...",
            "  Example: add n/John Doe p/98765432 e/johnd@example.com d/IT pos/Software Engineer t/fulltime",
            "",
            "delete",
            "  Deletes an employee by unique name or list index.",
            "  Allowed input: NAME or INDEX.",
            "  Example: delete John Doe",
            "  Example: delete 2",
            "",
            "edit",
            "  Edits an employee identified by index.",
            "  Allowed input: INDEX with one or more optional fields",
            "  Fields: [n/NAME] [p/PHONE] [e/EMAIL] [d/DEPARTMENT] [pos/POSITION] [t/TAG]...",
            "  Example: edit 1 p/91234567 e/johndoe@example.com",
            "",
            "find",
            "  Finds employees whose names contain any keyword.",
            "  Allowed input: KEYWORD [MORE_KEYWORDS]...",
            "  Example: find alice bob charlie",
            "",
            "list",
            "  Lists all employees.",
            "  Allowed input: no additional parameters.",
            "  Example: list",
            "",
            "show",
            "  Filters employees by one or more fields.",
            "  Allowed input: at least one of n/ d/ p/ e/ pos/ t/ task/",
            "  Example: show n/Alex d/IT",
            "",
            "addtask",
            "  Adds a task to an employee by name.",
            "  Allowed input: task/TASK_NAME desc/TASK_DESCRIPTION n/EMPLOYEE_NAME",
            "  Example: addtask task/Prepare Report desc/Submit by Friday n/John Doe",
            "",
            "deletetask",
            "  Deletes a task by task index.",
            "  Allowed input: INDEX.",
            "  Example: deletetask 1",
            "",
            "clear",
            "  Clears all employees from the address book.",
            "  Allowed input: no additional parameters.",
            "  Example: clear",
            "",
            "exit",
            "  Exits ManageUp.",
            "  Allowed input: no additional parameters.",
            "  Example: exit",
            "",
            "Online user guide:",
            USERGUIDE_URL);

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private Button copyButton;

    @FXML
    private TextArea helpContent;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpContent.setText(HELP_WINDOW_CONTENT);
        helpContent.positionCaret(0);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     *     <ul>
     *         <li>
     *             if this method is called on a thread other than the JavaFX Application Thread.
     *         </li>
     *         <li>
     *             if this method is called during animation or layout processing.
     *         </li>
     *         <li>
     *             if this method is called on the primary stage.
     *         </li>
     *         <li>
     *             if {@code dialogStage} is already showing.
     *         </li>
     *     </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
        helpContent.positionCaret(0);
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
