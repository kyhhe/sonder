package cpen221A.sonder.TaskScreens;

import cpen221A.sonder.*;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Creates the screen which provides the user interface for Task 2: What is one thing you’re grateful for?.
 */
public class Task2Screen extends AbstractScreen {
    private TextArea input;
    private String answer;
    private Label warning;
    private Runnable onComplete;

    public Task2Screen(MainApplication main) {
        super(main);
    }

    @Override
    protected Parent createRoot() {
        // Initialize Screen elements
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Screen elements
        Label title = createTitle("introspect:");
        Label question = createText("what is one thing you’re grateful for?");

        Button nextButton = createButton("next");

        // Text box for user-inputted response
        this.input = new TextArea();
        this.input.setPrefRowCount(5);
        this.input.setStyle("-fx-border-color: #95d5b2;");

        // Warning message
        this.warning = createText("please fill in your response.");
        this.warning.setStyle("-fx-font-size: 13;");
        this.warning.setVisible(false);

        // Button action and task transition logic
        nextButton.setOnAction(e -> {
            if (this.input.getText().trim().isEmpty()) {
                this.warning.setVisible(true);
            } else {
                this.warning.setVisible(false);
                this.answer = this.input.getText().trim();

                if (this.onComplete != null) {
                    this.onComplete.run();
                }
            }
        });

        // Add elements to screen
        vbox.getChildren().addAll(title, question, this.input, this.warning, nextButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
    }

    /**
     * Gets input from user.
     *
     * @return String representing user's short answer response to task 2
     */
    public String getTask2Input() {
        return this.answer;
    }

    /**
     * Sets the action to run when the current task is completed. Used for transitioning to the next
     * screen.
     *
     * @param r the action to execute once the current task is completed
     */
    public void nextTask(Runnable r) {
        this.onComplete = r;
    }
}
