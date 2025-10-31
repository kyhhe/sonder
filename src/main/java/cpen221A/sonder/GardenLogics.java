package cpen221A.sonder;

import cpen221A.sonder.TaskScreens.Task4Screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GardenLogics {
    private static final int ROW = 3;
    private static final int COL = 5;
    private final List<List<Flower>> garden = new ArrayList<>(); // 2D array to represent the flower garden

    /**
     * Creates a new empty 3x5 garden to manage and place flowers.
     */
    public GardenLogics(){
        for (int row = 0; row < ROW; row++) {
            garden.add(new ArrayList<Flower>(Collections.nCopies(COL, null)));
        }
    }

    /**
     * Get the flower from the latest entry from the entries file.
     * @return the flower sequence
     */
    public Flower getFlower(){
        return null; //get from entries
    }

    /**
     * Add a flower to the garden.
     *
     * @param flowerName the flower to add
     * @param row the row of the position selected(0-2), position should not have flower previously
     * @param col the column of the position selected(0-4), position should not have flower previously
     * @return true if added flower to the garden, false otherwise
     * @throws IllegalArgumentException if position is invalid
     */
    public boolean addFlower(Flower flowerName, int row, int col){
        if(row < 0 || row >= ROW || col < 0 || col >= COL){
            throw new IllegalArgumentException("Invalid input positions");
        }
        return false;
    }

    /**
     * Checks if the position already has a flower
     *
     * @param x row index
     * @param y column index
     * @return true if the position is empty, false otherwise
     */
    public boolean hasFlower(int x, int y) {
        return false;
    }

    /**
     * Checks if the garden is full (reaches the 15th day)
     *
     * @return true if all 15 cells have flowers
     */
    public boolean isFull() {
        return false;
    }

    /**
     * Saves the current garden state
     */
    public void saveGarden(){

    }

    /**
     * Loads the garden state
     */
    public void loadGarden(){

    }

    /**
     * Determines if the given flower if already planted in the garden. Returns true if the flower
     * is already present, falser otherwise.
     *
     * @param flower the flower to check
     * @return true if the flower has already been planted, false otherwise.
     */
    public boolean flowerInGarden(Flower flower) {
        return true;
    }
}
