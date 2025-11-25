package cpen221A.sonder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Main application for sonder
 */
public class MainApplication extends Application {
    private Stage stage;
    private LocalDateTime date = LocalDateTime.now();
    //private GardenLogic gardenManager;

    @Override
    public void start(Stage newStage) throws IOException {
        this.stage = newStage;
        //this.gardenManager = new GardenLogic();

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

        stage.setTitle("sonder");
        showMainMenu();
        stage.show();
    }

    /**
     * Shows the main menu screen
     */
    public void showMainMenu() {
        MainMenuScreen menu = new MainMenuScreen(this);
        stage.setScene(menu.getScene());
    }

    /**
     * Shows the garden screen
     */
    public void showGardenScreen() {
        GardenScreen gardenScreen = new GardenScreen(this);
        stage.setScene(gardenScreen.getScene());
    }

    /**
     * Shows the entries screen
     */
    public void showEntriesScreen() {
        EntriesScreen entriesScreen = new EntriesScreen(this);
        stage.setScene(entriesScreen.getScene());
    }

    /**
     * Loads the sequence of tasks and the logic which controls it
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
     * Obtains the current date and time in the game's clock.
     *
     * @return the game's current date and time
     */
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * Updates the game's clock to a new date.
     *
     * @param newDate the game's new date .
     */
    public void setDate(LocalDateTime newDate) {

        this.date = newDate;
    }

    /**
     * Main function to launch application
     */
    public static void main(String[] args) {
        launch();
    }
}
