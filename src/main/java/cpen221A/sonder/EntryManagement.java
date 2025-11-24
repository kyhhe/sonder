package cpen221A.sonder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class EntryManagement {
    private static final String JSONFILE = "data/json/entries.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Initialize the JSON file with an empty list of entries.
     */
    public static void initializeJSON() {
        List<UserEntry> empty = List.of();
        try (FileWriter writer = new FileWriter(JSONFILE)) {
            GSON.toJson(empty, writer);
            System.out.println("Successfully initialized JSON file to " + JSONFILE);
        } catch (IOException e) {
            System.out.println("Error initializing JSON file: " + e.getMessage());
        }
    }

    /**
     * Reads the content of the user entry JSON file and returns the list of UserEntries.
     * Returns an empty list if the file cannot be read.
     * @return List of the user's previous entries.
     */
    public static List<UserEntry> readEntries() {
        Type entriesMapType = new TypeToken<List<UserEntry>>() {
        }.getType();

        try (FileReader read = new FileReader(JSONFILE)) {
            return GSON.fromJson(read, entriesMapType);
        } catch (IOException e) {
            System.out.println("Could not read entries: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Updates the JSON file to save a new user entry.
     */
    public static void saveNewEntry(UserEntry newEntry) {
        List<UserEntry> entries = EntryManagement.readEntries();
        try (FileWriter writer = new FileWriter(JSONFILE)) {
            entries.add(newEntry);
            GSON.toJson(entries, writer);
            System.out.println("Successfully wrote entries to " + JSONFILE);
        } catch (IOException e) {
            System.out.println("Data could not be saved." + e.getMessage());
        }
    }
}
