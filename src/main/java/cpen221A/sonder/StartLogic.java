package cpen221A.sonder;

import cpen221A.sonder.TaskScreens.*;

import java.time.LocalDateTime;

public class StartLogic {
    Task1Screen task1Screen;
    Task2Screen task2Screen;
    Task3Screen task3Screen;
    Task4Screen task4Screen ;
    Task5Screen task5Screen;
    AllCompleteScreen allCompleteScreen;
    MainApplication main;

    public StartLogic(MainApplication main){
        this.main = main;
        task1Screen = new Task1Screen(main);
        task2Screen = new Task2Screen(main);
        task3Screen = new Task3Screen(main);
        task4Screen = new Task4Screen(main);
        task5Screen = new Task5Screen(main);
        allCompleteScreen = new AllCompleteScreen(main);

        task1Screen.nextTask(this::showTask2Screen);
        task2Screen.nextTask(this::showTask3Screen);
        task3Screen.nextTask(this::showTask4Screen);
        task4Screen.nextTask(this::showTask5Screen);
        task5Screen.nextTask(this::showAllCompleteScreen);
    }

    /**
     * Displays the corresponding task
     */
    public void start() {
        showTask1Screen();
    }

    /**
     * Updates the JSON file to save the user's entry once all tasks have been completed. Returns
     * true when all tasks have been completed and the entries have been saved to file. Returns false
     * otherwise.
     *
     * @return true if the user's entry has been saved to the file. False otherwise.
     */
    public boolean saveEntries() {
        LocalDateTime date = LocalDateTime.now();
        String answer1 = task1Screen.getTask1Input();
        String answer2 = task2Screen.getTask2Input();
        String answer3 = task3Screen.getTask3Input();
        Flower flower = task4Screen.getTask4Input();
        UserEntry entry;

        entry = new UserEntry(date, answer1, answer2, answer3, flower);
        if (entry.checkValidEntry()) {
            entry.saveEntry();
            return true;
        }
        return false;
    }

    /**
     * Shows the completed tasks screen
     */
    public void showAllCompleteScreen() {
        main.setStage(allCompleteScreen.getScene());
    }

    /**
     * Shows the task 1 screen
     */
    public void showTask1Screen() {
        main.setStage(task1Screen.getScene());
    }

    /**
     * Shows the task 2 screen
     */
    public void showTask2Screen() {
        main.setStage(task2Screen.getScene());
    }

    /**
     * Shows the task 3 screen
     */
    public void showTask3Screen() {
        main.setStage(task3Screen.getScene());
    }

    /**
     * Shows the task 4 screen
     */
    public void showTask4Screen() {
        main.setStage(task4Screen.getScene());
    }

    /**
     * Shows the task 5 screen
     */
    public void showTask5Screen() {
        main.setStage(task5Screen.getScene());
    }

}
