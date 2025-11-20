package cpen221A.sonder.TaskScreens;

import cpen221A.sonder.AbstractScreen;
import cpen221A.sonder.GeneralTasks;
import cpen221A.sonder.MainApplication;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Creates the screen which provides the user interface for Task 1: How are you feeling today?
 */
public class Task1Screen extends AbstractScreen implements GeneralTasks {

    private String answer;
    public String input = "";
    private Label warning;
    private Runnable onComplete;
    private boolean toNext = false;

    public Task1Screen(MainApplication main){
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
        Label title = createTitle("reflect:");
        Label question = createText("how are you feeling today?");
        Button nextButton = createButton("next");

        // Image selection elements
        HBox rowFaces = new HBox(25);
        rowFaces.setAlignment(Pos.CENTER);

        String[] faces = {
                "/FaceImages/Face1.PNG",
                "/FaceImages/Face2.PNG",
                "/FaceImages/Face3.PNG",
                "/FaceImages/Face4.PNG",
                "/FaceImages/Face5.PNG"
        };

        for(String face : faces) {
            Image img = new Image(getClass().getResource(face).toExternalForm());
            ImageView faceView = new ImageView(img);
            faceView.setFitWidth(150);
            faceView.setPreserveRatio(true);

            Button faceButton = new Button();
            faceButton.setGraphic(faceView);
            faceButton.setStyle("-fx-background-color: transparent; -fx-padding: 5;");

            faceButton.setOnAction(e -> {
                this.input = face;
                // add code for visible confirmation that button was selected
            });
            rowFaces.getChildren().add(faceButton);
        }

        // warning message
        warning = createText("please select one of the faces.");
        warning.setVisible(false);

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
        vbox.getChildren().addAll(title, question, rowFaces, this.warning, nextButton);
        VBox.setMargin(rowFaces, new Insets(20, 0, 20, 0));
        vbox.setAlignment(Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
    }

    /**
     * Gets input from user
     * (if user does not input a valid answer and presses enter, calls on warningMessage)
     * (otherwise, returns String input)
     * @return String representing user's short answer response to task 1
     */
    public String getTask1Input() {
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
