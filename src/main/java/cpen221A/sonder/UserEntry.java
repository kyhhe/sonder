package cpen221A.sonder;

import java.util.Date;

/**
 * Class representing the user's entry for the day.
 */
public class UserEntry {
    private Date date;
    private String task1;
    private String task2;
    private String task3;
    private Flower flower;

    /**
     * Creates a new entry representing the user's completed tasks for the day
     *
     * @param date the date of the completed task
     * @param task1 response to task 1 (mood selection)
     * @param task2 response to task 2 (gratitude)
     * @param task3 response to task 3 (learning/goal)
     * @param flower chosen flower for the day
     */
    public UserEntry(Date date, String task1, String task2, String task3, Flower flower) {}

    /**
     * Gets the date of entry creation
     *
     * @return the date of the entry.
     */
    public Date getDate() {
        return null;
    }

    /**
     * Gets the answer to task 1
     *
     * @return the answer to task 1
     */
    public String getTask1Answer() {
        return null;
    }

    /**
     * Gets the answer to task 2
     *
     * @return the answer to task 2
     */
    public String getTask2Answer() {
        return null;
    }

    /**
     * Gets the answer to task 3
     *
     * @return the answer to task 3
     */
    public String getTask3Answer() {
        return null;
    }

    /**
     * Gets the flower selected
     *
     * @return the flower selected during this entry
     */
    public Flower getFlower() {
        return null;
    }

    /**
     * Saves the entry to a JSON file
     */
    void saveEntry(){

    }
}
