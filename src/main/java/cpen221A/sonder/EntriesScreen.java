package cpen221A.sonder;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class EntriesScreen extends AbstractScreen{

    public EntriesScreen(MainApplication main){
        super(main);
    }

    protected Parent createRoot() {
        // Initialize Screen elements
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Screen elements
        Label title = createTitle("entries");
        Button backButton = createButton("menu");

        // Button actions
        backButton.setOnAction(e -> main.showMainMenu());

        // Add elements to screen
        vbox.getChildren().addAll(title, backButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
    }

    /**
     * Loads all past entries from saved data in JSON file
     */
    public void loadEntries(){}

    /**
     * Displays all entries on the screen
     */
    public void displayEntries(){}

    /**
     * Clears all stored entries if needed
     */
    public void clearEntries(){}

    /**
     * Checks if any entries are currently saved
     * @return true if at least one entry exists, false otherwise.
     */
    public boolean hasEntries(){
        return false;
    }

}
