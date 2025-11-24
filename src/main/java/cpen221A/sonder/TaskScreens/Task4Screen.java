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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Creates the screen which provides the user interface for Task 4: Choose a flower for your garden.
 */
public class Task4Screen extends AbstractScreen implements GeneralTasks {
    public Task4Screen(MainApplication main) {
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
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Screen elements
        Label title = createTitle("reward:");
        Label question = createText("choose a flower for your garden.");
        Button nextButton = createButton("next");

        // Image selection elements
        HBox rowFlowers = new HBox(25);
        rowFlowers.setAlignment(Pos.CENTER);

        // List of 15 flowers
        List<Flower> flowers = new ArrayList<>();
        flowers.add(new Flower(1));
        flowers.add(new Flower(2));
        flowers.add(new Flower(3));
        flowers.add(new Flower(4));
        flowers.add(new Flower(5));
        flowers.add(new Flower(6));
        flowers.add(new Flower(7));
        flowers.add(new Flower(8));
        flowers.add(new Flower(9));
        flowers.add(new Flower(10));
        flowers.add(new Flower(11));
        flowers.add(new Flower(12));
        flowers.add(new Flower(13));
        flowers.add(new Flower(14));
        flowers.add(new Flower(15));

        List<Flower> displayFlowers = getRandomFlowers(flowers);
        //if (gardenLogic.isFortnight()) {
        //    displayFlowers = Collections.singletonList(this.flower15);
        //}
        //else {
        //    displayFlowers = getRandomFlowers();
        //}

        for (Flower flower : displayFlowers) {
            Image img = new Image(getClass().getResource(flower.getImagePath()).toExternalForm());
            ImageView flowerView = new ImageView(img);
            flowerView.setFitWidth(150);
            flowerView.setPreserveRatio(true);

            Button faceButton = new Button();
            faceButton.setGraphic(flowerView);
            faceButton.setStyle("-fx-background-color: transparent; -fx-padding: 5;");

            DropShadow selectedShadow = new DropShadow();
            selectedShadow.setColor(Color.web("#8de0a1"));
            selectedShadow.setSpread(0.5);
            selectedShadow.setRadius(40);

            faceButton.setOnAction(e -> {
                this.input = flower;

                if (selectedButton != null) {
                    selectedButton.setEffect(null);
                }

                faceButton.setEffect(selectedShadow);
                selectedButton = faceButton;
            });

            rowFlowers.getChildren().add(faceButton);
        }

        // Warning message
        this.warning = createText("please select your flower of choice.");
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
                    this.onComplete.run();
                }
            }
        });

        // Add elements to screen
        vbox.getChildren().addAll(title, question, rowFlowers, this.warning, nextButton);
        VBox.setMargin(rowFlowers, new Insets(20, 0, 20, 0));
        vbox.setAlignment(Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
    }

    /**
     * Randomly selects 3 flowers from a set of 14 flowers.
     *
     * @return the list of 3 randomly selected flowers
     */
    private List<Flower> getRandomFlowers(List<Flower> flowers) {
        List<Flower> threeFlowers = new ArrayList<>(flowers);
        Collections.shuffle(threeFlowers);
        return threeFlowers.subList(0, 3);
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
        return this.toNext;
    }

    /**
     * Transitions to next task screen if current task is completed
     */
    public void nextTask(Runnable r) {
        this.onComplete = r;
    }
}
