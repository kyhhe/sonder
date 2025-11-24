package cpen221A.sonder.TaskScreens;

import cpen221A.sonder.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.awt.Point;

/**
 * Creates the screen which provides the user interface for Task 5: Plant your flower in the garden.
 */
public class Task5Screen extends AbstractScreen implements GeneralTasks {
    public Task5Screen(MainApplication main){
        super(main);
    }

    private Flower answer;
    public Flower input;
    private Label warning;
    private Runnable onComplete;
    private boolean toNext = false;
    private Button selectedButton = null;

    @Override
    protected Parent createRoot() {
        // Initialize Screen elements
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 10, 20));
        vbox.setSpacing(8);
        vbox.setStyle("-fx-background-color: #d8f3dc;");
        vbox.setMaxHeight(200);
        vbox.setFillWidth(true);
        StackPane pane = new StackPane();

        // Load GardenScreen
        GardenScreen gardenScreen = new GardenScreen(main);
        Parent gardenRoot = gardenScreen.getRoot();

        // Screen elements
        Label title = createTitle("cultivate:");
        Label question = createText("plant your flower into the garden.");
        Button nextButton = createButton("next");

        // Warning message
        this.warning = createText("please indicate where you'd like to plant your flower.");
        this.warning.setVisible(false);

        // Button action and task transition logic
        nextButton.setOnAction(e -> {
            if (this.input == null) {
                this.warning.setVisible(true);
            }
            else {
                this.warning.setVisible(false);
                this.answer = this.input;

                if (this.onComplete != null) {
                    this.toNext = true;
                    //gardenManager.addFlower(selectedFlower, selectedPosition.row, selectedPosition.col);
                    //gardenManager.saveGarden();
                    this.onComplete.run();
                }
            }
        });

        // Add elements to screen
        vbox.getChildren().addAll(title, question, this.warning, nextButton);
        vbox.setAlignment(Pos.TOP_CENTER);
        pane.getChildren().addAll(gardenRoot, vbox);
        pane.setAlignment(vbox, Pos.TOP_CENTER);

        return pane;
    }

    /**
     * Gets input from user
     * (if user does not input a valid answer and presses enter, calls on warningMessage)
     * (otherwise, returns String input)
     * @return String representing user's short answer response to task 5
     */
    public Flower getTask5Input() {
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