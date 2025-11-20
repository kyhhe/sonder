package cpen221A.sonder;

public interface GeneralTasks {

    /**
     * Returns current task completion status
     */
    boolean currentComplete();

    /**
     * Transitions to next task screen if current task is completed
     */
    void nextTask(Runnable r);
}

