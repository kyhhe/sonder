package cpen221A.sonder.TaskScreens;

import cpen221A.sonder.AbstractScreen;
import cpen221A.sonder.GeneralTasks;
import cpen221A.sonder.MainApplication;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Creates the screen which provides the user interface for Task 3: What is one thing you learned today? What is one goal you have for tomorrow?
 */
public class Task3Screen extends AbstractScreen implements GeneralTasks {
    public Task3Screen(MainApplication main){
        super(main);
    }

    private TextArea input;
    private String answer;
    private Label warning;
    private Runnable onComplete;
    private boolean toNext = false;

    @Override
    protected Parent createRoot() {
        // Initialize Screen elements
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Screen elements
        Label title = createTitle("aspire:");
        Label question = createText("what is one thing you learned today? what is one goal you have for tomorrow?");
        Button nextButton = createButton("next");

        // Text box for user-inputted response
        this.input = new TextArea();
        this.input.setStyle(
                "-fx-control-inner-background: #f2fff4;" +
                        "-fx-control-inner-background-insets: 0;" +
                        "-fx-border-color: #88bf89;" +
                        "-fx-border-width: 2;" +
                        "-fx-text-fill: #333333;"
        );
        this.input.setFont(Font.font("Verdana", 14));
        this.input.setWrapText(true);
        this.input.setPrefRowCount(5);
        this.input.setMaxWidth(600);

        // Warning message
        this.warning = createText("please fill in your response.");
        this.warning.setStyle("-fx-font-size: 13;");
        this.warning.setVisible(false);

        // Button action and task transition logic
        nextButton.setOnAction(e -> {
            if (this.input.getText().trim().isEmpty()) {
                this.warning.setVisible(true);
            }
            else {
                this.warning.setVisible(false);
                this.answer = this.input.getText().trim();

                if (this.onComplete != null) {
                    this.toNext = true;
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
     * Gets input from user
     * (if user does not input a valid answer and presses enter, calls on warningMessage)
     * (otherwise, returns String input)
     * @return String representing user's short answer response to task 3
     */
    public String getTask3Input() {
        return this.answer;
    }

    /**
     * Checks and returns task completion status
     *
     * @return true if user completes task, false otherwise
     */
    public boolean currentComplete() {
        return this.toNext;
    }

    /**
     * Transitions to next task screen if current task is completed
     */
    public void nextTask(Runnable r) {
        this.onComplete = r;
    }
}
