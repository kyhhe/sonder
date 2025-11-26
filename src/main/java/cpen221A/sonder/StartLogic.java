package cpen221A.sonder;

import cpen221A.sonder.TaskScreens.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Class which manages the tasks when the user selects the "Start" button. Supports the following operations:
 * <li> Shows the current task screen</li>
 * <li> Shows the next task screen </li>
 * <li> Writes the completed entry to the entries JSON file </li>
 * <li> Shows the task complete screen when the daily tasks have been completed </li>
 */
public class StartLogic {
    private final Task1Screen task1Screen;
    private final Task2Screen task2Screen;
    private final Task3Screen task3Screen;
    private final Task4Screen task4Screen;
    private final Task5Screen task5Screen;
    private final AllCompleteScreen allCompleteScreen;
    private final MainApplication main;

    /**
     * Creates a new StartLogic instance to manage the tasks and collect the entries from by the user.
     * Shows the next task once the current task has been completed, and the user initiates the next
     * task.
     *
     * @param main the main application.
     */
    public StartLogic(MainApplication main) {
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
        task4Screen.nextTask(() -> {
            Flower myFlower = task4Screen.getTask4Input();
            task5Screen.setMyFlower(myFlower);
            showTask5Screen();
        });
        task5Screen.nextTask(() -> {
            saveEntries();
            showAllCompleteScreen();
        });
    }

    /**
     * Starts the tasks sequence. If the task for the day has not yet been completed, then displays
     * the "All Complete" screen. Otherwise, displays the "Task 1" screen. If the JSON file is empty,
     * (i.e. it is the player's first entry), then a new JSON file is initialized.
     */
    public void start() {
        List<UserEntry> entries = EntryManagement.readEntries();
        boolean entryComplete = false;

        if (entries == null) {
            EntryManagement.initializeJSON();
            entries = EntryManagement.readEntries();
        }

        if (entries != null && !entries.isEmpty()) {
            for (UserEntry entry : entries) {
                if (entry.getDate().equals(DateTimeFormatter.ISO_LOCAL_DATE.format(main.getDate()))) {
                    entryComplete = true;
                    break;
                }
            }
        }

        if (entryComplete || GardenLogic.isFull()) {
            showAllCompleteScreen();
        } else {
            showTask1Screen();
        }
    }

    /**
     * Updates the JSON file to save the user's entry once all tasks have been completed. Returns
     * true when all tasks have been completed and the entries have been saved to file. Returns false
     * otherwise.
     *
     * @return true if the user's entry has been saved to the file. False otherwise.
     */
    public boolean saveEntries() {
        LocalDateTime date = main.getDate();
        String answer1 = task1Screen.getTask1Input();
        String answer2 = task2Screen.getTask2Input();
        String answer3 = task3Screen.getTask3Input();
        Flower flower = task5Screen.getTask5Input();
        UserEntry entry = new UserEntry(date, answer1, answer2, answer3, flower);

        if (entry.checkValidEntry()) {
            EntryManagement.saveNewEntry(entry);
            return true;
        } else {
            return false;
        }
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
