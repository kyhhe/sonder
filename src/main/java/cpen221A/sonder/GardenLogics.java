package cpen221A.sonder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class which handles the logic for retrieving and writing garden data.
 */
public class GardenLogics {
    private static final int ROW = 3;
    private static final int COL = 5;
    private final List<List<Flower>> garden = new ArrayList<>(); // 2D array to represent the flower garden
    private final String jsonPath = "src/main/resources/gardenData.json";
    private final Gson gson = new GsonBuilder().excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT).create();

    /**
     * Creates a new empty 3x5 garden to manage and place flowers.
     */
    public GardenLogics(){
        for (int row = 0; row < ROW; row++) {
            garden.add(new ArrayList<Flower>(Collections.nCopies(COL, (Flower) null)));
        }
    }

    /**
     * Getter method of garden
     */
    public List<List<Flower>> getGarden(){
        List<List<Flower>> g = new ArrayList<>();
        for(int r=0; r<ROW;r++){
            List<Flower> row =new ArrayList<>();
            for(int c=0; c<COL; c++){
                row.add(garden.get(r).get(c));
            }
            g.add(row);
        }
        return g;
    }

    /**
     * Add a flower to the garden.
     *
     * @param flower the flower to add
     * @param row the row of the position selected(0-2), position should not have flower previously
     * @param col the column of the position selected(0-4), position should not have flower previously
     * @return true if added flower to the garden, false otherwise
     * @throws IllegalArgumentException if position is invalid
     */
    public boolean addFlower(Flower flower, int row, int col){
        if(row < 0 || row >= ROW || col < 0 || col >= COL){
            throw new IllegalArgumentException("Invalid input positions");
        }
        if(garden.get(row).get(col) != null){
            return false;
        }
        garden.get(row).set(col,flower);
        flower.setPosition(row,col);
        return true;
    }

    /**
     * Checks if the position is empty (no flower)
     *
     * @param row row index
     * @param col column index
     * @return true if the position is empty, false otherwise
     */
    public boolean isEmpty(int row, int col) {
        if(row<0 || row>=ROW || col<0 || col >= COL){
            throw new IllegalArgumentException("Invalid input position");
        }
        return garden.get(row).get(col) == null;
    }

    /**
     * Checks if the garden has exactly 14 flowers planted.
     *
     * @return true if all 15 cells have flowers
     */
    public boolean isFortnight() {
        int emptyCount = 0;

        for(List<Flower> r: garden){
            for(Flower c: r){
                if(c==null){
                    emptyCount++;
                }
            }
        }

        if(emptyCount == 1) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the garden is full (reaches the 15th day)
     *
     * @return true if all 15 cells have flowers
     */
    public boolean isFull() {
        for(List<Flower> r: garden){
            for(Flower c: r){
                if(c==null){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Saves the current garden state
     */
    public void saveGarden(){
        try(FileWriter write = new FileWriter(jsonPath)){
            gson.toJson(this.garden,write);
        }catch(IOException e){
            System.out.println("Incorrect saving garden: " + e.getMessage());
        }
    }

    /**
     * Loads the garden state
     */
    public void loadGarden(){
        try(FileReader read = new FileReader(jsonPath)){
            List<List<Flower>> load = gson.fromJson(read, new TypeToken<List<List<Flower>>>(){}.getType());
            if(load!=null){
                for(int r=0; r<ROW;r++){
                    for(int c=0; c<COL; c++){
                        this.garden.get(r).set(c, load.get(r).get(c));
                    }
                }
            }
        }catch(IOException e){
            System.out.println("Incorrect loading garden: "+ e.getMessage());
        }
    }

    /**
     * Determines if the given flower if already planted in the garden. Returns true if the flower
     * is already present, falser otherwise.
     *
     * @param flower the flower to check
     * @return true if the flower has already been planted, false otherwise.
     */
    public boolean flowerInGarden(Flower flower) {
        for(List<Flower> r: garden){
            for(Flower f: r){
                if(f!=null && f.equals(flower)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Clear the garden in the JSON file
     */
    public void clearGarden(){
        for(int r=0; r<ROW;r++){
            for(int c=0; c<COL; c++){
                this.garden.get(r).set(c, null);
            }
        }
        saveGarden();
    }

    //debug importing flower into json
    public static void main(String[] args) {
        GardenLogics g = new GardenLogics();
        g.loadGarden();
        Flower f = new Flower(11);
        g.addFlower(f, 2, 0);
        Flower f2 = new Flower(12);
        g.addFlower(f2, 2, 1);
        Flower f3 = new Flower(13);
        g.addFlower(f3, 2, 2);
        Flower f4 = new Flower(14);
        g.addFlower(f4, 2, 3);
        Flower f5 = new Flower(15);
        g.addFlower(f5, 2, 4);
//        g.clearGarden();
        g.saveGarden();
    }


}
