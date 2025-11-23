package cpen221A.sonder;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class EntriesScreen extends AbstractScreen{
    private List<UserEntry> entries = new ArrayList<>();
    private VBox entriesContainer;   // The vertical list of entry nodes


    /**
     * Creates the screen which displays the user's past entries
     *
     * @param main the main application where the screen is displayed
     */
    public EntriesScreen(MainApplication main){
        super(main);
    }

    @Override
    protected Parent createRoot() {

        VBox root = new VBox(20);
        root.setPadding(new Insets(10));

        // Menu button
        Button backButton = createButton("menu");
        backButton.setOnAction(e -> main.showMainMenu());

        // Title
        Label title = createTitle("entries");

        // Menu button and title in one line
        BorderPane topBar = new BorderPane();
        topBar.setLeft(backButton);
        topBar.setCenter(title);

        // Invisible spacer so title is centered
        Region spacer = new Region();
        spacer.setMinWidth(70);  // adjust for button width
        topBar.setRight(spacer);
        
        topBar.setPadding(new Insets(10));
        topBar.setMaxWidth(Double.MAX_VALUE);

        // Entries list container
        entriesContainer = new VBox(15);
        entriesContainer.setPadding(new Insets(10));

        ScrollPane scrollPane = new ScrollPane(entriesContainer);
        scrollPane.setFitToWidth(true);

        root.getChildren().addAll(topBar, scrollPane);

        loadEntries();
        displayEntries();

        return root;
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
