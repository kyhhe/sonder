package cpen221A.sonder;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application for sonder
 */
public class MainApplication extends Application {
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setTitle("sonder");
        showMainMenu();
        stage.show();
    }

    /**
     * Shows the main menu screen
     */
    public void showMainMenu() {
        MainMenu menu = new MainMenu(this);
        stage.setScene(menu.getScene());
    }

    /**
     * Shows the Start screen
     */
    public void showStartScreen() {
        StartScreen startScreen = new StartScreen(this);
        stage.setScene(startScreen.getScene());
    }

    /**
     * Shows the Garden screen
     */
    public void showGardenScreen() {
        GardenScreen gardenScreen = new GardenScreen(this);
        stage.setScene(gardenScreen.getScene());
    }

    /**
     * Shows the Entries screen
     */
    public void showEntriesScreen() {
        EntriesScreen entriesScreen = new EntriesScreen(this);
        stage.setScene(entriesScreen.getScene());
    }

    /**
     * Main function to launch application
     */
    public static void main(String[] args) {
        launch();
    }
}