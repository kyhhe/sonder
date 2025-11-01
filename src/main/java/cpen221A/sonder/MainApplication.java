package cpen221A.sonder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application for sonder
 */
public class MainApplication extends Application {
    private Stage stage;
    private TaskManager taskManager;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        this.taskManager = new TaskManager(this);

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
     * Loads the sequence of tasks and the logic w
     */
    public void startTasks() {
        StartLogic startLogic = new StartLogic(this);
        startLogic.start();
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    public void setStage(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main function to launch application
     */
    public static void main(String[] args) {
        launch();
    }
}