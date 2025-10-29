package cpen221A.sonder;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainMenu {
    private final Scene scene;

    public MainMenu(MainApplication main) {
        // Initialize screen containers
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();
        scene = new Scene(pane, 1024, 768);

        // Screen elements
        Button startButton = new Button("start");
        Button gardenButton = new Button("garden");
        Button entriesButton = new Button("entries");

        Text title = new Text("sonder");
        title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));

        // Add elements to screen
        vbox.getChildren().addAll(title, startButton, gardenButton, entriesButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        // Button actions
        startButton.setOnAction(e -> main.showStartScreen());
        gardenButton.setOnAction(e -> main.showGardenScreen());
        entriesButton.setOnAction(e -> main.showEntriesScreen());
    }

    public Scene getScene() {
        return scene;
    }
}
