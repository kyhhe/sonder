
package cpen221A.sonder;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class EntriesScreen extends AbstractScreen {

    private VBox entriesContainer;

    public EntriesScreen(MainApplication main) {
        super(main);
    }

    /**
     * Builds and initializes root UI layout for Entries Screen
     * @return the Parent node for the Entries screen.
     */
    @Override
    protected Parent createRoot() {

        VBox root = new VBox(20);
        root.setPadding(new Insets(10));

        // Top bar
        Button backButton = createButton("menu");
        backButton.setOnAction(e -> main.showMainMenu());

        Label title = createTitle("entries");

        BorderPane topBar = new BorderPane();
        topBar.setLeft(backButton);
        topBar.setCenter(title);
        topBar.setPadding(new Insets(10));
        topBar.setMaxWidth(Double.MAX_VALUE);
        BorderPane.setAlignment(title, Pos.CENTER);

        // Right spacer to visually center the title
        Region spacer = new Region();
        spacer.setMinWidth(70);
        topBar.setRight(spacer);

        // Entries container
        entriesContainer = new VBox(15);
        entriesContainer.setPadding(new Insets(10, 20, 10, 10));

        ScrollPane scrollPane = new ScrollPane(entriesContainer);
        entriesContainer.setFillWidth(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPannable(true);

        root.getChildren().addAll(topBar, scrollPane);

        loadEntries();

        return root;
    }

    /**
     * Loads the entries from the JSON file
     */
    public void loadEntries() {
        List<UserEntry> entries = EntryManagement.readEntries();
        entriesContainer.getChildren().clear();

        if (entries.isEmpty()) {
            Label empty = createText("no entries yet");
            empty.getStyleClass().add("empty-text");
            empty.setPadding(new Insets(40, 0, 0, 0));
            empty.setAlignment(Pos.CENTER);
            empty.setMaxWidth(Double.MAX_VALUE);
            entriesContainer.setAlignment(Pos.CENTER);
            entriesContainer.getChildren().add(empty);

            return;
        }

        // Sort newest -> oldest
        List<UserEntry> sorted = new ArrayList<>(entries);
        sorted.sort(Comparator.comparing(UserEntry::getDate).reversed());

        for (UserEntry entry : sorted) {
            entriesContainer.getChildren().add(buildEntryBox(entry));
        }
    }

    /**
     * Builds a single collapsible UI past user entry box
     * @param entry saved user entry to display
     * @return an entry box with all three tasks and flower image and date
     */
    private VBox buildEntryBox(UserEntry entry) {
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));
        box.getStyleClass().add("entry-box");
        box.setFocusTraversable(false);
        box.setMaxWidth(Double.MAX_VALUE);
        box.setFillWidth(true);

        // Header
        HBox header = new HBox(10);
        header.setAlignment(Pos.CENTER_LEFT);

        // Arrow icon for collapsible box
        Label arrow = new Label("►");
        arrow.setStyle("-fx-font-size: 20; -fx-padding: 0 5 0 0;");

        // Flower icon
        ImageView flowerIcon = null;
        try {
            flowerIcon = new ImageView(new Image(
                    Objects.requireNonNull(
                            getClass().getResource(entry.getFlower().getImagePath())
                    ).toExternalForm()
            ));
            flowerIcon.setFitWidth(50);
            flowerIcon.setFitHeight(50);
        } catch (Exception e) {
            System.out.println("Could not load flower image: " + e.getMessage());
        }

        // Date label
        Label date = createText(entry.getDate());
        date.setStyle("-fx-font-style: italic; -fx-font-size: 22;");

        header.getChildren().addAll(arrow, flowerIcon, date);

        // Details
        VBox details = new VBox(12);
        details.setPadding(new Insets(10, 0, 0, 50));

        // Task1 Image
        ImageView faceImage = null;
        try {
            faceImage = new ImageView(new Image(
                    Objects.requireNonNull(getClass().getResource(entry.getTask1Answer())).toExternalForm()
            ));
            faceImage.setFitWidth(40);
            faceImage.setFitHeight(40);
        } catch (Exception e) {
            System.out.println("Could not load face image: " + e.getMessage());
        }

        // Task Headers
        Label moodLabel = new Label("mood:");
        Label gratitudeLabel = new Label("gratitude:");
        Label learningLabel = new Label("lesson / goal:");
        moodLabel.getStyleClass().add("task-title");
        gratitudeLabel.getStyleClass().add("task-title");
        learningLabel.getStyleClass().add("task-title");
        learningLabel.setWrapText(true);
        learningLabel.setMaxWidth(Double.MAX_VALUE);

        // Values
        Label gratitudeValue = createText(entry.getTask2Answer());
        gratitudeValue.setWrapText(true);
        gratitudeValue.setMaxWidth(800);

        Label learningValue = createText(entry.getTask3Answer());
        learningValue.setWrapText(true);
        learningValue.setMaxWidth(800);

        // Layout rows so headers never disappear
        HBox moodRow = new HBox(10, moodLabel, faceImage);
        moodRow.setAlignment(Pos.TOP_LEFT);

        HBox gratitudeRow = new HBox(10, gratitudeLabel, gratitudeValue);
        gratitudeRow.setAlignment(Pos.BASELINE_LEFT);
        HBox.setHgrow(gratitudeValue, Priority.ALWAYS);

        HBox learningRow = new HBox(10, learningLabel, learningValue);
        learningRow.setAlignment(Pos.BASELINE_LEFT);
        HBox.setHgrow(learningValue, Priority.ALWAYS);

        details.getChildren().addAll(moodRow, gratitudeRow, learningRow);

        details.setVisible(false);
        details.setManaged(false);

        // Toggle behaviour
        header.setOnMouseClicked(e -> {
            boolean show = !details.isVisible();
            arrow.setText(show ? "▼" : "►");

            details.setVisible(show);
            details.setManaged(show);
        });

        box.getChildren().addAll(header, details);

        return box;
    }


    /**
     * Clears entries in JSON file
     */
    public void clearEntries() {
        EntryManagement.initializeJSON();
        entriesContainer.getChildren().clear();
    }

    /**
     * Checks if there are entries in the JSON file
     * @return true if there are entries, false otherwise
     */
    public boolean hasEntries() {
        return !EntryManagement.readEntries().isEmpty();
    }
}
