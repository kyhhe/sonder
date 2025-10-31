package cpen221A.sonder;

import cpen221A.sonder.TaskScreens.Task4Screen;

public class GardenLogics {
    private static final int ROW = 3;
    private static final int COL = 5;
    private final String[][] fPosition;

    public GardenLogics(){
        fPosition = new String[ROW][COL];
    }
    /**
     * Get the flower selected by user of the day.
     * @return the flower sequence
     */
    public String getFlower(){
        return Task4Screen.getTask4Input(); //get from Task4Screen
    }

    /**
     * Add a flower to the garden.
     *
     * @param flowerName the name/type of the flower
     * @param row the row of the position selected(0-2), position should not have flower previously
     * @param col the column of the position selected(0-4), position should not have flower previously
     * @return true if added flower to the garden, false otherwise
     * @throws IllegalArgumentException if position is invalid
     */
    public boolean addFlower(String flowerName, int row, int col){
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
}
