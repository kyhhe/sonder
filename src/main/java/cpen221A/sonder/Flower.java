package cpen221A.sonder;

import javafx.scene.image.Image;

/**
 * Class containing methods for creating, modifying and representing flowers. Each flower has a unique
 * ID, with each ID corresponding to a respective image.
 */
public class Flower {
    private int flowerId;
    private int row = -1;
    private int col = -1;
    private transient Image flowerImage;

    public Flower(){}

    /**
     * Creates a new flower object without position in garden
     * @param id Unique ID to represent the flower object and its corresponding image (1-15)
     * @throws IllegalArgumentException invalid input of flower input
     */
    public Flower(int id) throws IllegalArgumentException {
        if(id < 1 || id > 15){
            throw new IllegalArgumentException("Invalid flower object input");
        }
        this.flowerId =id;
    }

    /**
     * Create a new flower object with position in garden
     * @param id unique ID for the flower type (1-15)
     * @param row garden row (0-2)
     * @param col garden colume (0-4)
     * @throws IllegalArgumentException invalid input of flower input
     */
    public Flower(int id, int row, int col) throws IllegalArgumentException{
        if(id < 1 || id > 15 || row < 0 || row > 2 || col < 0 || col > 4){
            throw new IllegalArgumentException("Invalid flower object input");
        }
        this.flowerId =id;
        this.row = row;
        this.col= col;
    }

    // Getters methods
    public int getId() { return flowerId; }
    public int getRow() { return row; }
    public int getCol() { return col; }

    // Setters methods for changing/setting location of flower
    public void setRow(int row){ this.row = row;}
    public void setCol(int col){ this.col = col;}
    public void setPosition(int row, int col){
        this.row=row;
        this.col=col;
    }

    /**
     * Return if the flower is planted in the garden
     * @return true if it has a position in the garden, false otherwise
     */
    public boolean hasPlanted() {
        return row >= 0 && col >= 0;
    }

    /**
     * Determine the path to each flower image
     * @return the path of each flower in string
     */
    public String getImagePath() {
       return "/FlowerImages/Flower" + flowerId+".PNG";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){return true;}
        if(!(o instanceof Flower)){ return false;}
        Flower f= (Flower) o;
        return this.flowerId == f.flowerId;
    }

    @Override
    public int hashCode() {
        return flowerId + row * 10 + col * 100;
    }

    @Override
    public String toString(){
        return "Flower{" + "id="+ flowerId + ", row="
                + row+", col="+col+", imagePath="+getImagePath()+"}";
    }
}
