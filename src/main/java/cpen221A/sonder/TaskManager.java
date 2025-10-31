package cpen221A.sonder;

import cpen221A.sonder.TaskScreens.Task1Screen;
import cpen221A.sonder.TaskScreens.Task2Screen;
import cpen221A.sonder.TaskScreens.Task3Screen;
import cpen221A.sonder.TaskScreens.Task4Screen;
import cpen221A.sonder.TaskScreens.Task5Screen;
import cpen221A.sonder.TaskScreens.AllCompleteScreen;

public class TaskManager {
    private final Task1Screen task1;
    private final Task2Screen task2;
    private final Task3Screen task3;
    private final Task4Screen task4;
    private final Task5Screen task5;

    public TaskManager(MainApplication main) {
        this.task1 = new Task1Screen(main);
        this.task2 = new Task2Screen(main);
        this.task3 = new Task3Screen(main);
        this.task4 = new Task4Screen(main);
        this.task5 = new Task5Screen(main);
    }

    /**
     * Returns total task completion status
     *
     * @return true if all five tasks are complete, false otherwise
     */
    public boolean allComplete() {
        return task1.currentComplete() && task2.currentComplete() && task3.currentComplete()
               && task4.currentComplete() && task5.currentComplete();
    }
}
