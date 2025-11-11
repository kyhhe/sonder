package cpen221A.sonder;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.util.List;
import java.util.Random;

public class MainMenuScreen extends AbstractScreen{

    private static final List<String> messages = List.of("welcome, let's recharge and refocus",
        "cultivate your daily mindfulness", "let's plant something positive today",
        "welcome back gardener of your own mind", "what will you grow today?");

    /**
     * Initializes the main menu screen
     *
     * @param main the main application
     */
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
        Label welcomeMessage = createText(welcomeMessage());

        // Button actions
        startButton.setOnAction(e -> main.startTasks());
        gardenButton.setOnAction(e -> main.showGardenScreen());
        entriesButton.setOnAction(e -> main.showEntriesScreen());

        // Add elements to screen
        vbox.getChildren().addAll(title, welcomeMessage, startButton, gardenButton, entriesButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
    }

    /**
     * Randomly selects a welcome message out of the pool of welcome messages
     * to display on the main menu screen.
     *
     * @return a random message selected from the pool of messages
     */
    public String welcomeMessage() {
        Random rand = new Random();
        int randomNum = rand.nextInt(messages.size() + 1);
        return messages.get(randomNum);
    }
}
