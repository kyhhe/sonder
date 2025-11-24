package cpen221A.sonder.TaskScreens;

import cpen221A.sonder.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.awt.Point;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Creates the screen which provides the user interface for Task 5: Plant your flower in the garden.
 */
public class Task5Screen extends AbstractScreen implements GeneralTasks {
//    private GardenLogic gardenManager;
    private GardenLogic gardenLogic;  //<--initialize a new gardenLogic object

    public Task5Screen(MainApplication main, GardenLogic gardenManager){
        super(main);
//        this.gardenManager = gardenManager;
        this.gardenLogic = new GardenLogic();   //<--create GardenLogic object
    }

    private Flower answer;
    public Flower input;
    private Flower myFlower;
    private Label warning;
    private Label invalid;
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
        this.warning.setStyle("-fx-font-size: 13;");
        this.warning.setVisible(false);

        // Invalid message
        this.invalid = createText("please choose an empty spot in the garden.");
        this.invalid.setStyle("-fx-font-size: 13;");
        this.invalid.setVisible(false);

        // Grid of buttons for user selection
        GridPane gardenButtons = new GridPane();
        gardenButtons.setHgap(30);
        gardenButtons.setVgap(12);
        gardenButtons.setPadding(new Insets(270, 0, 0, 75));

        DropShadow selectedShadow = new DropShadow();
        selectedShadow.setColor(Color.web("#24f057"));
        selectedShadow.setSpread(0.8);
        selectedShadow.setRadius(50);


        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 5; c++) {
                Button gardenButton = new Button();
                gardenButton.setPrefSize(150, 150);
                gardenButton.setStyle("-fx-background-color: transparent;" +
                        "-fx-border-color: #95d5b2;" +
                        "-fx-border-width: 2;");

                int row = r, col = c;
                gardenButton.setOnAction(e -> {
                    this.input = this.myFlower;
                    this.input.setPosition(row, col);

                    if (selectedButton != null) {
                        selectedButton.setEffect(null);
                    }

                    gardenButton.setEffect(selectedShadow);
                    selectedButton = gardenButton;
                });

                gardenButtons.add(gardenButton, c, r);
            }
        }

        // Button action and task transition logic
        nextButton.setOnAction(e -> {
            if (this.input == null) { // no input
                this.warning.setVisible(true);
            }
            else {
                this.warning.setVisible(false);

                int row = this.input.getRow();
                int col = this.input.getCol();

                if(!this.gardenLogic.isEmpty(row, col)) { // invalid spot
                    this.invalid.setVisible(true);
                }
                else {
                    this.invalid.setVisible(false);
                    this.answer = this.input;

                    if (this.onComplete != null) {
                        this.toNext = true;
                        GardenLogic.loadGarden();   //<--load the garden from .json to the object
                        this.gardenLogic.addFlower(this.answer, row, col);  //<--do the implement of adding flower
                        GardenLogic.saveGarden();   //<--save the garden to .json
                        this.onComplete.run();
                    }
                }
            }
        });

        // Add elements to screen
        vbox.getChildren().addAll(title, question, this.warning, this.invalid, nextButton);
        vbox.setAlignment(Pos.TOP_CENTER);
        pane.getChildren().addAll(gardenRoot, gardenButtons, vbox);
        pane.setAlignment(vbox, Pos.TOP_CENTER);

        return pane;
    }

    /**
     * Sets flower to the one chosen in task 4.
     */
    public void setMyFlower(Flower flower) {
        this.myFlower = flower;
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
        return this.toNext;
    }

    /**
     * Transitions to next task screen if current task is completed
     */
    public void nextTask(Runnable r) {
        this.onComplete = r;
    }

}