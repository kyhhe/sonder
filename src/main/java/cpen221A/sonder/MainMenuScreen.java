package cpen221A.sonder;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * The main menu screen. Supports the following operations:
 * <li>Button to navigate to the daily tasks</li>
 * <li>Button to navigate to the garden/li>
 * <li>Button to navigate to the user entries</li>
 * <li>Shortcut keys with commands for testing purposes</li>
 * <li>Displays the game's title and a randomly selected message</li>
 *
 * @see AbstractScreen
 * @see GardenScreen
 * @see EntriesScreen
 */
public class MainMenuScreen extends AbstractScreen {

    private static final List<String> MESSAGES = List.of(
        "welcome, let's recharge and refocus",
        "cultivate your daily mindfulness",
        "let's plant something positive today",
        "welcome, gardener of your own mind",
        "what will you grow today?",
        "ready to flourish?");
    private static final List<Integer> FLOWERS = List.of(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);

    /**
     * Initializes the main menu screen
     *
     * @param main the main application
     */
    public MainMenuScreen(MainApplication main) {
        super(main);
    }

    /**
     * Overrides the parent class. Creates the root containing the screen size, layout and elements.
     *
     * @return the root of the main menu screen.
     */
    @Override
    protected Parent createRoot() {
        // Initialize screen containers
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Screen elements
        Label title = createTitle("sonder");
        title.setStyle("-fx-font-size: 70;");

        Label welcomeMessage = createText(welcomeMessage());
        welcomeMessage.setStyle("-fx-font-size: 20;");
        welcomeMessage.setPadding(new Insets(0, 0, 5, 0));

        Label currentDate = createText(DateTimeFormatter.ISO_LOCAL_DATE.format(main.getDate()));
        currentDate.setStyle("-fx-font-size: 17;" + "-fx-font-style: italic;");
        currentDate.setPadding(new Insets(5));

        Button startButton = createButton("start");
        Button gardenButton = createButton("garden");
        Button entriesButton = createButton("entries");

        Image flower = new Image(Objects.requireNonNull(
            getClass().getResource(new Flower(flowerDisplay()).getImagePath())).toExternalForm());
        ImageView flowerView = new ImageView(flower);
        flowerView.setFitWidth(180);
        flowerView.setPreserveRatio(true);

        // Button actions
        startButton.setOnAction(e -> main.startTasks());
        gardenButton.setOnAction(e -> main.showGardenScreen());
        entriesButton.setOnAction(e -> main.showEntriesScreen());

        // Add elements to screen
        vbox.getChildren().addAll(flowerView, title, welcomeMessage,
                startButton, gardenButton, entriesButton, currentDate);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
    }

    /**
     * Randomly selects a welcome message out of the pool of welcome messages to display on
     * the main menu screen.
     *
     * @return a random message selected from the pool of 6 messages.
     */
    public String welcomeMessage() {
        Random rand = new Random();
        int randomNum = rand.nextInt(MESSAGES.size());
        return MESSAGES.get(randomNum);
    }

    private int flowerDisplay() {
        Random rand = new Random();
        int randomFlower = rand.nextInt(FLOWERS.size());
        return FLOWERS.get(randomFlower);
    }

    /**
     * Overrides parent class to implement functionality for keyboard presses while on main menu screen.
     * <li> F1: advances system clock by one day. </li>
     * <li> F2: loads flowers 1-14 to the first 14 cells of the garden </li>
     * <li> F3: loads flowers 1-15 to the 15 cells of the garden </li>
     * <li> F12: clears all user garden data and entry data </li>
     *
     * @param keyEvent keypress from the user.
     */
    @Override
    protected void onKeyPressed(javafx.scene.input.KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.F1)) {
            System.out.println("NEXT DAY");
            main.setDate(main.getDate().plusDays(1));
            main.showMainMenu();
        }

        if (keyEvent.getCode().equals(KeyCode.F2)) {
            System.out.println("14 FLOWERS LOADED");
            GardenLogic.set14Flowers();
            main.showMainMenu();
        }

        if (keyEvent.getCode().equals(KeyCode.F3)) {
            System.out.println("ALL FLOWERS LOADED");
            GardenLogic.setAllFlowers();
            main.showMainMenu();
        }

        if (keyEvent.getCode().equals(KeyCode.F12)) {
            System.out.println("DATA CLEARED");
            GardenLogic.clearGarden();
            EntryManagement.initializeJSON();
            main.showMainMenu();
        }
    }
}
