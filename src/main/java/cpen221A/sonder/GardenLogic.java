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
 * Handles loading, saving, and modifying the flower GARDEN.
 * The GARDEN is represented as a 3x5 grid, where each cell may contain a Flower object or be empty.
 * The class provides operations for:
 * <li>Adding flowers</li>
 * <li>Checking GARDEN status (full, 14 flowers, empty cells)</li>
 * <li>Loading and storing GARDEN layout from/to JSON</li>
 * <li>Utility operations used by UI logic</li>
 */
public class GardenLogic {
    private static final int ROW = 3;
    private static final int COL = 5;

    private static final List<List<Flower>> GARDEN = new ArrayList<>();
    private static final String JSONFILE = "data/json/gardenData.json";
    private static final Gson GSON =
            new GsonBuilder().excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT).
                setPrettyPrinting().create();

    // Initializes the 3x5 GARDEN and loads saved state
    static {
        for (int i = 0; i < ROW; i++) {
            GARDEN.add(new ArrayList<>(Collections.nCopies(COL, null)));
        }
        loadGarden();
    }

    /**
     * Return a deep copy of the GARDEN structure
     *
     * @return a copy of the 3x5 GARDEN grid
     */
    public static List<List<Flower>> getGarden() {
        List<List<Flower>> g = new ArrayList<>();
        for (int r = 0; r < ROW; r++) {
            List<Flower> row = new ArrayList<>();
            for (int c = 0; c < COL; c++) {
                row.add(GARDEN.get(r).get(c));
            }
            g.add(row);
        }
        return g;
    }

    /**
     * Attempt to place a flower into the GARDEN at the position
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
        if (GARDEN.get(row).get(col) != null) {
            return false;
        }

        GARDEN.get(row).set(col, flower);
        flower.setPosition(row, col);
        return true;
    }

    /**
     * Checks if the position in the GARDEN contains no flower.
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
        return GARDEN.get(row).get(col) == null;
    }

    /**
     * Checks if the GARDEN has exactly 14 flowers and 1 empty cell.
     *
     * @return true if exactly one cell is empty
     */
    public static boolean isFortnight() {
        int emptyCount = 0;
        for (List<Flower> r : GARDEN) {
            for (Flower c : r) {
                if (c == null) {
                    emptyCount++;
                }
            }
        }
        return emptyCount == 1;
    }

    /**
     * Checks if the GARDEN has all 15 cells are filled
     *
     * @return true if the GARDEN contains 15 flowers
     */
    public static boolean isFull() {
        for (List<Flower> r : GARDEN) {
            for (Flower c : r) {
                if (c == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Saves the current GARDEN state to JSON file.
     */
    public static void saveGarden() {
        try (FileWriter write = new FileWriter(JSONFILE)) {
            GSON.toJson(GARDEN, write);
        } catch (IOException e) {
            System.out.println("Could not save garden: " + e.getMessage());
        }
    }

    /**
     * Loads the GARDEN state from the JSON file, if it exists.
     */
    public static void loadGarden() {
        try (FileReader read = new FileReader(JSONFILE)) {
            List<List<Flower>> load = GSON.fromJson(read, new TypeToken<List<List<Flower>>>() {
            }.getType());
            if (load != null) {
                for (int r = 0; r < ROW; r++) {
                    for (int c = 0; c < COL; c++) {
                        GARDEN.get(r).set(c, load.get(r).get(c));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Incorrect loading GARDEN: " + e.getMessage());
        }
    }

    /**
     * Checks if a flower already exists in somewhere in the GARDEN.
     *
     * @param flower the flower to check
     * @return true if the flower is found in the GARDEN
     */
    public static boolean flowerInGarden(Flower flower) {
        for (List<Flower> r : GARDEN) {
            for (Flower f : r) {
                if (f != null && f.equals(flower)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Clears the GARDEN by removing all flowers and saving the empty grid.
     */
    public static void clearGarden() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                GARDEN.get(r).set(c, null);
            }
        }
        saveGarden();
    }

    /**
     * Fills the GARDEN with flowers of ID 1-15.
     */
    public static void setAllFlowers() {
        int id = 1;
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                GARDEN.get(r).set(c, new Flower(id));
                id++;
            }
        }
        saveGarden();
    }

    /**
     * Fills the GARDEN with flowers of ID 1-14, and the last cell (right bottom) empty.
     */
    public static void set14Flowers() {
        setAllFlowers();
        GARDEN.get(ROW - 1).set(COL - 1, null);
        saveGarden();
    }
}
