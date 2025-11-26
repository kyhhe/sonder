package cpen221A.sonder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.ObjectUtils;


/**
 * Class representing the user's entry for the day. Supports the following operations:
 * <li> getDate: obtains the date of the entry</li>
 * <li> getTask1Answer - getTask3Answer: obtains the answer from the specified task/li>
 * <li> getFlower: obtains the flower selected by the user</li>
 * <li> checkValidEntry: checks if all fields of the entry are non-null</li>
 */
public class UserEntry {
    private final String date;
    private final String task1;
    private final String task2;
    private final String task3;
    private final Flower flower;

    /**
     * Creates a new entry representing the user's completed tasks for the day
     *
     * @param date the date of the completed task
     * @param task1 response to task 1 (mood selection)
     * @param task2 response to task 2 (gratitude)
     * @param task3 response to task 3 (learning/goal)
     * @param flower chosen flower for the day
     */
    public UserEntry(LocalDateTime date, String task1, String task2, String task3, Flower flower) {
        this.date = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
        this.task1 = task1;
        this.task2 = task2;
        this.task3 = task3;
        this.flower = flower;
    }

    /**
     * Gets the date of entry creation
     *
     * @return the date of the entry.
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets the answer to task 1
     *
     * @return the answer to task 1
     */
    public String getTask1Answer() {
        return task1;
    }

    /**
     * Gets the answer to task 2
     *
     * @return the answer to task 2
     */
    public String getTask2Answer() {
        return task2;
    }

    /**
     * Gets the answer to task 3
     *
     * @return the answer to task 3
     */
    public String getTask3Answer() {
        return task3;
    }

    /**
     * Gets the flower selected
     *
     * @return the flower selected during this entry
     */
    public Flower getFlower() {
        return flower;
    }

    /**
     * Checks if the entry is valid (no null fields)
     *
     * @return true if the entry is valid, false if at least one field is empty.
     */
    public boolean checkValidEntry() {
        return !ObjectUtils.anyNull(this.date, this.task1, this.task2, this.task3, this.flower);
    }
}
