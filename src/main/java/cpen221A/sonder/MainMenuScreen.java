package cpen221A.sonder;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainMenuScreen extends AbstractScreen{

    public MainMenuScreen(MainApplication main) {
        super(main);
    }

    @Override
    protected Parent createRoot() {
        // Initialize screen containers
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Gets task manager
        TaskManager taskManager = main.getTaskManager();

        // Screen elements
        Button startButton = createButton("start");
        Button gardenButton = createButton("garden");
        Button entriesButton = createButton("entries");

        Label title = createTitle("sonder");

        // Button actions
        if(taskManager.allComplete()) {
            startButton.setOnAction(e -> main.showAllCompleteScreen());
        }
        else {
            startButton.setOnAction(e -> main.showTask1Screen());
        }
        gardenButton.setOnAction(e -> main.showGardenScreen());
        entriesButton.setOnAction(e -> main.showEntriesScreen());

        // Add elements to screen
        vbox.getChildren().addAll(title, startButton, gardenButton, entriesButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
    }
}
