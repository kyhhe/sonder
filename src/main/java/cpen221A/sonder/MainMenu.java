package cpen221A.sonder;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainMenu extends AbstractScreen{

    public MainMenu(MainApplication main) {
        super(main);
    }

    @Override
    protected Parent createRoot() {
        // Initialize screen containers
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Screen elements
        Button startButton = createButton("start");
        Button gardenButton = createButton("garden");
        Button entriesButton = createButton("entries");

        Label title = createTitle("sonder");

        // Button actions
        startButton.setOnAction(e -> main.showStartScreen());
        gardenButton.setOnAction(e -> main.showGardenScreen());
        entriesButton.setOnAction(e -> main.showEntriesScreen());

        // Add elements to screen
        vbox.getChildren().addAll(title, startButton, gardenButton, entriesButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
    }
}
