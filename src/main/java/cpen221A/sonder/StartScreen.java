package cpen221A.sonder;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class StartScreen extends AbstractScreen{

    public StartScreen(MainApplication main){ super(main); }

    @Override
    protected Parent createRoot() {
        // Initialize Screen elements
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Screen elements
        Label title = createTitle("start");
        Button backButton = createButton("menu");

        // Button actions
        backButton.setOnAction(e -> main.showMainMenu());

        // Add elements to screen
        vbox.getChildren().addAll(title, backButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
    }

    TaskManager taskManager = main.getTaskManager();

    private void taskTransition() {
        if(!taskManager.allComplete() && ) {

        }
        else if (taskManager.allComplete()) {
            main.showAllCompleteScreen();
        }

    }


    public void taskScreen() {
        if (taskManager.allComplete()) {
            main.showAllCompleteScreen();
        }
    }
}
