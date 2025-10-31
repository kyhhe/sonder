package cpen221A.sonder.TaskScreens;

import cpen221A.sonder.AbstractScreen;
import cpen221A.sonder.GeneralTasks;
import cpen221A.sonder.MainApplication;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.awt.Point;

//Task 5: Plant your flower in the garden.
public class Task5Screen extends AbstractScreen implements GeneralTasks {
    public Task5Screen(MainApplication main){
        super(main);
    }

    private Point answer;
    private Label warning;

    @Override
    protected Parent createRoot() {
        // Initialize Screen elements
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Screen elements
        Label title = createTitle("cultivate:");
        Label question = createText("plant your flower into the garden.");
        Button backButton = createButton("menu");

        warning = createText("please indicate where you'd like to plant your flower.");
        warning.setVisible(false);

        // Button actions
        backButton.setOnAction(e -> main.showMainMenu());

        // Add elements to screen
        vbox.getChildren().addAll(title, question, warning, backButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
    }

    /**
     * Gets input from user
     * (if user does not input a valid answer and presses enter, calls on warningMessage)
     * (otherwise, returns String input)
     * @return String representing user's short answer response to task 5
     */
    public Point getTask5Input() {
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
    public void nextTask() {
    }

}
