package cpen221A.sonder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Handles loading, saving, and modifying the flower garden.
 * The garden is represented as a 3x5 grid, where each cell may contain a Flower object or be empty.
 * The class provides operations for:
 * <li>Adding flowers</li>
 * <li>Checking garden status (full, 14 flowers, empty cells)</li>
 * <li>Loading and storing garden layout from/to JSON</li>
 * <li>Utility operations used by UI logic</li>
 */
public class GardenLogic {
    private static final int ROW = 3;
    private static final int COL = 5;

    private static final List<List<Flower>> garden = new ArrayList<>();
    private static final String jsonPath = "data/json/gardenData.json";

    private static final Gson gson =
            new GsonBuilder().excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT)
                    .setPrettyPrinting().create();

    // Initializes the 3x5 garden and loads saved state
    static {
        for (int i = 0; i < ROW; i++) {
            garden.add(new ArrayList<>(Collections.nCopies(COL, null)));
        }
        loadGarden();
    }

    /**
     * Return a deep copy of the garden structure
     *
     * @return a copy of the 3x5 garden grid
     */
    public static List<List<Flower>> getGarden() {
        List<List<Flower>> g = new ArrayList<>();
        for (int r = 0; r < ROW; r++) {
            List<Flower> row = new ArrayList<>();
            for (int c = 0; c < COL; c++) {
                row.add(garden.get(r).get(c));
            }
            g.add(row);
        }
        return g;
    }

    /**
     * Attempt to place a flower into the garden at the position
     * A position may only be filled if it was previously empty.
     *
     * @param flower the flower to place
     * @param row    row index (0-2)
     * @param col    column index (0-4)
     * @return true if the flower is successfully added, false if the position is already placed by another flower
     * @throws IllegalArgumentException if position is out of the range
     */
    public static boolean addFlower(Flower flower, int row, int col) {
        if (row < 0 || row >= ROW || col < 0 || col >= COL) {
            throw new IllegalArgumentException("Invalid input positions");
        }
        if (garden.get(row).get(col) != null) {
            return false;
        }

        garden.get(row).set(col, flower);
        flower.setPosition(row, col);
        return true;
    }

    /**
     * Checks if the position in the garden contains no flower.
     *
     * @param row row index (0-2)
     * @param col column index (0-4)
     * @return true if the position is empty, false otherwise
     * @throws IllegalArgumentException if the position is out of range
     */
    public static boolean isEmpty(int row, int col) {
        if (row < 0 || row >= ROW || col < 0 || col >= COL) {
            throw new IllegalArgumentException("Invalid input position");
        }
        return garden.get(row).get(col) == null;
    }

    /**
     * Checks if the garden has exactly 14 flowers and 1 empty cell.
     *
     * @return true if exactly one cell is empty
     */
    public static boolean isFortnight() {
        int emptyCount = 0;
        for (List<Flower> r : garden) {
            for (Flower c : r) {
                if (c == null) {
                    emptyCount++;
                }
            }
        }
        return emptyCount == 1;
    }

    /**
     * Checks if the garden has all 15 cells are filled
     *
     * @return true if the garden contains 15 flowers
     */
    public static boolean isFull() {
        for (List<Flower> r : garden) {
            for (Flower c : r) {
                if (c == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Saves the current garden state to JSON file.
     */
    public static void saveGarden() {
        try (FileWriter write = new FileWriter(jsonPath)) {
            gson.toJson(garden, write);
        } catch (IOException e) {
            System.out.println("Incorrect saving garden: " + e.getMessage());
        }
    }

    /**
     * Loads the garden state from the JSON file, if it exists.
     */
    public static void loadGarden() {
        try (FileReader read = new FileReader(jsonPath)) {
            List<List<Flower>> load = gson.fromJson(read, new TypeToken<List<List<Flower>>>() {
            }.getType());
            if (load != null) {
                for (int r = 0; r < ROW; r++) {
                    for (int c = 0; c < COL; c++) {
                        garden.get(r).set(c, load.get(r).get(c));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Incorrect loading garden: " + e.getMessage());
        }
    }

    /**
     * Checks if a flower already exists in somewhere in the garden.
     *
     * @param flower the flower to check
     * @return true if the flower is found in the garden
     */
    public static boolean flowerInGarden(Flower flower) {
        for (List<Flower> r : garden) {
            for (Flower f : r) {
                if (f != null && f.equals(flower)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Clears the garden by removing all flowers and saving the empty grid.
     */
    public static void clearGarden() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                garden.get(r).set(c, null);
            }
        }
        saveGarden();
    }

    /**
     * Fills the garden with flowers of ID 1-15.
     */
    public static void setAllFlowers() {
        int id = 1;
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                garden.get(r).set(c, new Flower(id));
                id++;
            }
        }
        saveGarden();
    }

    /**
     * Fills the garden with flowers of ID 1-14, and the last cell (right bottom) empty.
     */
    public static void set14Flowers() {
        setAllFlowers();
        garden.get(ROW - 1).set(COL - 1, null);
        saveGarden();
    }
}
