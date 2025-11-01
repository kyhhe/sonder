package cpen221A.sonder.TaskScreens;

import cpen221A.sonder.*;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Creates the screen which provides the user interface for Task 4: Choose a flower for your garden.
 */
public class Task4Screen extends AbstractScreen implements GeneralTasks {
    public Task4Screen(MainApplication main){
        super(main);
    }

    private Flower answer;
    private Label warning;
    private Runnable onComplete;

    @Override
    protected Parent createRoot() {
        // Initialize Screen elements
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Screen elements
        Label title = createTitle("reward:");
        Label question = createText("choose a flower for your garden.");
        Button backButton = createButton("menu");
        Button nextButton = createButton("next");

        warning = createText("please select your flower of choice.");
        warning.setVisible(false);

        // Button actions
        backButton.setOnAction(e -> main.showMainMenu());
        nextButton.setOnAction(e ->  {if (onComplete != null) {
            onComplete.run();}
        });

        // Add elements to screen
        vbox.getChildren().addAll(title, question, warning, backButton, nextButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
    }

    /**
     * Gets input from user
     * (if user does not input a valid answer and presses enter, calls on warningMessage)
     * (otherwise, returns user input)
     * @return Flower object selected by the user's response to task 4
     */
    public Flower getTask4Input() {
        return this.answer;
    }

    /**
     * Checks and returns task completion status
     *
     * @return true if user completes task, false otherwise
     */
    public boolean currentComplete() {
        return false;
    }

    /**
     * Displays a custom warning message on the task screen
     */
    public void warningMessage() {
        warning.setVisible(true);
    }

    /**
     * Transitions to next task screen if current task is completed
     */
    public void nextTask(Runnable r) {
        this.onComplete = r;
    }
}
