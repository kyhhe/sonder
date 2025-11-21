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

/**
 * Creates the screen which provides the user interface for Task 4: Choose a flower for your garden.
 */
public class Task4Screen extends AbstractScreen implements GeneralTasks {
    public Task4Screen(MainApplication main){
        super(main);
    }

    private String answer;
    public String input = "";
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

        String[] faces = {
                "/FlowerImages/Flower1.PNG",
                "/FlowerImages/Flower2.PNG",
                "/FlowerImages/Flower3.PNG",
                "/FlowerImages/Flower4.PNG",
                "/FlowerImages/Flower5.PNG",
                "/FlowerImages/Flower5.PNG",
                "/FlowerImages/Flower6.PNG",
                "/FlowerImages/Flower7.PNG",
                "/FlowerImages/Flower8.PNG",
                "/FlowerImages/Flower9.PNG",
                "/FlowerImages/Flower10.PNG",
                "/FlowerImages/Flower11.PNG",
                "/FlowerImages/Flower12.PNG",
                "/FlowerImages/Flower13.PNG",
                "/FlowerImages/Flower14.PNG",
        };

        String specialFace = "/FlowerImages/Flower15.PNG";

        for(String face : faces) {
            Image img = new Image(getClass().getResource(face).toExternalForm());
            ImageView faceView = new ImageView(img);
            faceView.setFitWidth(150);
            faceView.setPreserveRatio(true);

            Button faceButton = new Button();
            faceButton.setGraphic(faceView);
            faceButton.setStyle("-fx-background-color: transparent; -fx-padding: 5;");

            DropShadow selectedShadow = new DropShadow();
            selectedShadow.setColor(Color.web("#37de61"));
            selectedShadow.setSpread(0.5);
            selectedShadow.setRadius(40);

            faceButton.setOnAction(e -> {
                this.input = face;

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
            if (this.input == null || this.input.isEmpty()) {
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
     * Gets input from user
     * (if user does not input a valid answer and presses enter, calls on warningMessage)
     * (otherwise, returns user input)
     * @return Flower object selected by the user's response to task 4
     */
    public String getTask4Input() {
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
