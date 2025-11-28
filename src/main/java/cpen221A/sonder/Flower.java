package cpen221A.sonder;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.Objects;

/**
 * Class representing a flower object used in the garden. Each flower is represented by a unique ID
 * from 1-15. Flower 15 is a special flower and has a sparkle overlay.
 * This class supports the following operations:
 * <li>Creates a flower with a unique ID (1-15)</li>
 * <li>Stores and updates the flower's position in the garden</li>
 * <li>Retrieves the corresponding image path for the flower</li>
 *
 * @see GardenLogic
 */
public class Flower {
    private final int flowerId;

    private int row = -1;
    private int col = -1;

    /**
     * Creates a new flower object with the given ID. The ID corresponds to its flower image.
     * Valid flower IDs are interger between 1-15.
     *
     * @param id Unique ID to represent the flower and its corresponding image (1-15)
     * @throws IllegalArgumentException if the ID is out of range
     */
    public Flower(int id) throws IllegalArgumentException {
        if (id < 1 || id > 15) {
            throw new IllegalArgumentException("Invalid flower object input");
        }
        this.flowerId = id;
    }

    /**
     * Returns this flower's unique ID.
     *
     * @return the flower ID
     */
    public int getId() {
        return flowerId;
    }

    /**
     * Return the row that this flower is placed in within the garden grid.
     * Return -1 if the flower has not yet been placed.
     *
     * @return the flower's row in the garden
     */
    public int getRow() {
        return row;
    }

    /**
     * Return the column that this flower is placed in within the garden grid.
     * Return -1 if the flower has not yet been placed.
     *
     * @return the flower's column in the garden
     */
    public int getCol() {
        return col;
    }

    /**
     * Updates the flower's position in the garden grid.
     *
     * @param row the row index where is the flower is placed
     * @param col the column index where is the flower is placed
     */
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Return the resouce path for the image corresponding to this flower's ID.
     * Image of flowers follows the naming format:
     * <li>"Flower1.PNG</li>
     * <li>"Flower2.PNG</li>
     * ...
     * <li>"Flower14.PNG</li>
     * <li>"Flower15.PNG</li>
     *
     * @return the image file path for this flower
     */
    public String getImagePath() {
        return "/FlowerImages/Flower" + flowerId + ".PNG";
    }

    /**
     * Creates a JavaFX node representing this flower at the given size.
     * If the flower is the special flower (ID = 15), a sparkle animation will be automatically
     * overlay on top.
     * @param size the width and height (in pixels) to scale the flower
     * @return a {@code StackPane} containing the flower image. May include
     * the sparkle overlay if this is the special flower.
     * @throws NullPointerException if the flower image resource cannot be found.
     */
    public StackPane getDisplayNode(int size) {
        // Base flower image
        Image baseImage = new Image(
                Objects.requireNonNull(getClass().getResource(getImagePath())).toExternalForm()
        );

        ImageView baseView = new ImageView(baseImage);
        baseView.setFitWidth(size);
        baseView.setPreserveRatio(true);

        StackPane wrapper = new StackPane(baseView);
        wrapper.setPrefSize(size, size);

        // Add sparkle overlay automatically for flower 15
        if (flowerId == 15) {
            Image sparkleImage = new Image(
                    Objects.requireNonNull(getClass().getResource("/FlowerImages/sparkle.gif")).toExternalForm()
            );
            ImageView sparkle = new ImageView(sparkleImage);
            sparkle.setFitWidth(size);
            sparkle.setFitHeight(size);

            wrapper.getChildren().add(sparkle);
        }

        return wrapper;
    }


}
