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

public class GardenScreen {
    private final Scene scene;

    public GardenScreen(MainApplication main) {
        // Initialize Screen elements
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();
        scene = new Scene(pane, 1024, 768);

        // Screen elements
        Text title = new Text("garden");
        title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 24));
        Button backButton = new Button("back");

        // Add elements to screen
        vbox.getChildren().addAll(title, backButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        // Button actions
        backButton.setOnAction(e -> main.showMainMenu());
    }

    public Scene getScene() {
        return scene;
    }
}
