package cpen221A.sonder;

import javafx.application.Application;
import javafx.stage.Stage;

import cpen221A.sonder.TaskScreens.Task1Screen;
import cpen221A.sonder.TaskScreens.Task2Screen;
import cpen221A.sonder.TaskScreens.Task3Screen;
import cpen221A.sonder.TaskScreens.Task4Screen;
import cpen221A.sonder.TaskScreens.Task5Screen;
import cpen221A.sonder.TaskScreens.AllCompleteScreen;

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
     * Shows the start screen
     */
    public void showStartScreen() {
        StartScreen startScreen = new StartScreen(this);
        stage.setScene(startScreen.getScene());
    }

    /**
     * Shows the entries screen
     */
    public void showEntriesScreen() {
        EntriesScreen entriesScreen = new EntriesScreen(this);
        stage.setScene(entriesScreen.getScene());
    }

    public void showAllCompleteScreen() {
        AllCompleteScreen allCompleteScreen = new AllCompleteScreen(this);
        stage.setScene(allCompleteScreen.getScene());
    }

    public void showTask1Screen() {
        Task1Screen task1Screen = new Task1Screen(this);
        stage.setScene(task1Screen.getScene());
    }

    public void showTask2Screen() {
        Task2Screen task2Screen = new Task2Screen(this);
        stage.setScene(task2Screen.getScene());
    }

    public void showTask3Screen() {
        Task3Screen task3Screen = new Task3Screen(this);
        stage.setScene(task3Screen.getScene());
    }

    public void showTask4Screen() {
        Task4Screen task4Screen = new Task4Screen(this);
        stage.setScene(task4Screen.getScene());
    }

    public void showTask5Screen() {
        Task5Screen task5Screen = new Task5Screen(this);
        stage.setScene(task5Screen.getScene());
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    /**
     * Main function to launch application
     */
    public static void main(String[] args) {
        launch();
    }
}