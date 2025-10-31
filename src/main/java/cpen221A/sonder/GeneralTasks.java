package cpen221A.sonder;

public interface GeneralTasks {

    /**
     * Returns current task completion status
     *
     * @return true iif user has completed the current task (ie. valid input), false otherwise
     */
    public boolean currentComplete();

    /**
     * Determines if user has pressed ENTER to move onto next task
     *
     * @return true if the user has pressed ENTER, false otherwise
     */
    public boolean inputEnter();

    /**
     * Displays a warning message on the task screen if no valid user input and user pressed ENTER
     *
     * @param inputEnter if user has pressed ENTER
     */
    public void warningMessage(boolean isComplete, boolean inputEnter);


    /**
     * Returns total task completion status
     *
     * @return true if all tasks are complete, false otherwise
     */
    public boolean allComplete();
}
