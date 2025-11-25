package cpen221A.sonder.TaskScreens;

import cpen221A.sonder.AbstractScreen;
import cpen221A.sonder.Flower;
import cpen221A.sonder.GardenLogic;
import cpen221A.sonder.MainApplication;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class AllCompleteScreen extends AbstractScreen {

    /**
     * Creates the screen displayed when the user has already completed all tasks
     *
     * @param main the main application where the screen is displayed
     */
    public AllCompleteScreen(MainApplication main){ super(main); }

    @Override
    protected Parent createRoot() {
        // Initialize Screen elements
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Screen elements
        Label title1 = createTitle("thank you for logging today's entry.");
        Label subtitle1 = createText("check back in tomorrow :)");

        Label title2 = createTitle("your garden is in full bloom!");
        Label subtitle2 = createText("thanks for planting with us.");

        Button menuButton = createButton("menu");

        Image flower = new Image(getClass().getResource(new Flower(15).getImagePath()).toExternalForm());
        ImageView flowerView = new ImageView(flower);
        flowerView.setFitWidth(180);
        flowerView.setPreserveRatio(true);

        // Screen elements display logic
        if(GardenLogic.isFull() || GardenLogic.isFortnight()) {
            vbox.getChildren().addAll(flowerView, title2, subtitle2, menuButton);
        } else {
            vbox.getChildren().addAll(title1, subtitle1, menuButton);
        }

        // Button actions
        menuButton.setOnAction(e -> main.showMainMenu());

        // Add elements to screen
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
    }
}