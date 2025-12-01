package cpen221A.sonder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p> Main application class for sonder, a mental-health focused gardening game, where users log-in daily to
 * complete wellness tasks during a 15-day period </p>
 * <p> This project was created for CPEN 221 A, Term 1 2025 </p>
 *
 * <p>This class is the entry point of the JavaFX application. It handles the following operations
 * <li>Initialization of data files</li>
 * <li>Initialization of UI and sound</li>
 * <li>Date tracking</li>
 * <li>Screen navigation</li>
 *
 * @author Bella Chen, Kelly He, Anna Jian, Candice Lei
 * @version 1.0
 * @since 2025-11-28
 */
public class MainApplication extends Application {
    private Stage stage;
    private LocalDateTime date = LocalDateTime.now();

    /**
     * Starts the application. Initializes the data files if they do not exist. Plays the background
     * music present in all screens and displays the Main Menu screen to begin.
     *
     * @param newStage initial stage for the application
     */
    @Override
    public void start(Stage newStage) {
        this.stage = newStage;

        // Checks if data files exist. 
        File entriesFile = new File("data/json/entries.json");
        File gardenFile = new File("data/json/gardenData.json");
        if (!entriesFile.exists()) {
            EntryManagement.initializeJSON();
        }
        if (!gardenFile.exists()) {
            GardenLogic.clearGarden();
        }

        // Plays music
        AudioClip bgMusic = new AudioClip(
            Objects.requireNonNull(getClass().getResource("/audio/The Mercy of the Wind.mp3")).toString());
        bgMusic.setCycleCount(AudioClip.INDEFINITE);
        bgMusic.play();

        Image appIcon = new Image(
            Objects.requireNonNull(getClass().getResourceAsStream("/FlowerImages/Flower1.png")));
        stage.setTitle("sonder");
        stage.getIcons().add(appIcon);
        showMainMenu();
        stage.show();
    }

    /**
     * Shows the main menu screen.
     */
    public void showMainMenu() {
        MainMenuScreen menu = new MainMenuScreen(this);
        stage.setScene(menu.getScene());
    }

    /**
     * Shows the garden screen.
     */
    public void showGardenScreen() {
        GardenScreen gardenScreen = new GardenScreen(this);
        stage.setScene(gardenScreen.getScene());
    }

    /**
     * Shows the entries screen.
     */
    public void showEntriesScreen() {
        EntriesScreen entriesScreen = new EntriesScreen(this);
        stage.setScene(entriesScreen.getScene());
    }

    /**
     * Begins the sequence of tasks. Loads the sequence of tasks and the logic which controls it.
     */
    public void startTasks() {
        StartLogic startLogic = new StartLogic(this);
        startLogic.start();
    }

    /**
     * Method to change the scene which is currently being displayed to the user.
     *
     * @param scene the scene to display.
     */
    public void setStage(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Obtains the current date and time being used in the game's clock.
     *
     * @return the game's current date and time
     */
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * Updates the game's clock to a new date, used for testing purposes
     *
     * @param newDate the game's new date .
     */
    public void setDate(LocalDateTime newDate) {
        this.date = newDate;
    }

    public void buttonSound() {
        AudioClip buttonClick = new AudioClip(
            Objects.requireNonNull(getClass().getResource("/audio/button.mp3")).toString());
        buttonClick.play();
    }
    /**
     * Main function to launch application
     */
    public static void main(String[] args) {
        launch();
    }
}
