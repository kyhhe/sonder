package cpen221A.sonder;

public interface GeneralTasks {

    /**
     * Returns current task completion status
     *
     * @return true iif user has completed the current task (i.e. valid input), false otherwise
     */
    boolean currentComplete();

    /**
     * Determines if user has pressed ENTER to move onto next task
     *
     * @return true if the user has pressed ENTER, false otherwise
     */
    boolean inputEnter();

    /**
     * Displays a warning message on the task screen if no valid user input and user pressed ENTER
     *
     * @param inputEnter if user has pressed ENTER
     */
    void warningMessage(boolean isComplete, boolean inputEnter);
}
