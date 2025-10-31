package cpen221A.sonder;

public interface GeneralTasks {

    /**
     * Returns current task completion status
     */
    boolean currentComplete();

    /**
     * Displays a warning message on the task screen
     */
    void warningMessage();

    /**
     * Transitions to next task screen if current task is completed
     */
    void nextTask();
}
