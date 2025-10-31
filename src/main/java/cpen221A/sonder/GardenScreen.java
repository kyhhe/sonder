package cpen221A.sonder;

import cpen221A.sonder.TaskScreens.Task4Screen;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GardenScreen extends AbstractScreen{

    public GardenScreen(MainApplication main) {
        super(main);
    }

    @Override
    protected Parent createRoot() {
        // Initialize Screen elements
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Screen elements
        Label title = createTitle("garden");
        Button backButton = createButton("menu");

        // Button actions
        backButton.setOnAction(e -> main.showMainMenu());

        // Add elements to screen
        vbox.getChildren().addAll(title, backButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().add(vbox);

        return pane;
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
     * @param positionX the row of the position selected(0-2), position should not have flower previously
     * @param positionY the column of the position selected(0-4), position should not have flower previously
     * @return true if added flower to the garden, false otherwise
     * @throws IllegalArgumentException if position is invalid
     */
    public boolean addFlower(String flowerName, int positionX, int positionY){
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
