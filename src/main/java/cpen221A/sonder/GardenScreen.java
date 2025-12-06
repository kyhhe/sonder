package cpen221A.sonder;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.*;

/**
 * The garden screen displays the user's current garden and the flowers obtained.
 * This class supports the following operations:
 * <li>Display the garden background image</li>
 * <li>Displays a 3x5 grid representing the user's flower garden</li>
 * <li>Loads flowers using stored garden data</li>
 * <li>Shows empty placeholder for empty cell</li>
 * <li>Include a button to navigate to menu</li>
 *
 * @see AbstractScreen
 * @see MainMenuScreen
 * @see GardenLogic
 */
public class GardenScreen extends AbstractScreen {
    /**
     * Construct a GardenScreen and loads the garden.
     *
     * @param main the main application
     */
    public GardenScreen(MainApplication main) {
        super(main);
        GardenLogic.loadGarden();
    }

    /**
     * Overrides the parent class. Creates the root containing the screen size, layout and elements.
     *
     * @return the root of the main menu screen.
     */
    @Override
    protected Parent createRoot() {
        GardenLogic.loadGarden();

        // Initialize Screen elements
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Top bar with menu button
        Button backButton = createButton("menu");
        BorderPane pos = new BorderPane();
        pos.setLeft(backButton);
        pos.setPadding(new Insets(10));

        // Menu button actions
        backButton.setOnAction(e -> {
            main.showMainMenu();
            main.buttonSound();
        });

        // Background image
        ImageView bgView = new ImageView(new Image(
                Objects.requireNonNull(getClass().getResource("/ScreenImages/Garden.png")).toExternalForm()
        ));
        bgView.setFitWidth(1024);
        bgView.setFitHeight(768);
        bgView.setPreserveRatio(false);

        // Create grid for flowers
        GridPane grid = new GridPane();
        grid.setHgap(30);
        grid.setVgap(12);
        grid.setPadding(new Insets(270,0,0,75));

        // Load flowers into grid
        List<List<Flower>> garden = GardenLogic.getGarden();
        for (int r = 0; r < garden.size(); r++) {
            for (int c = 0; c < garden.get(r).size(); c++) {
                Flower f = garden.get(r).get(c);

                if (f != null && f.getImagePath() != null) {
                    StackPane flowerPane = f.getDisplayNode(150);
                    DropShadow shadow = new DropShadow();
                    shadow.setRadius(20);
                    shadow.setOffsetX(0);
                    shadow.setOffsetY(8);
                    shadow.setColor(Color.web("#0b3d0b"));
                    flowerPane.setEffect(shadow);
                    grid.add(flowerPane, c, r);


                } else {
                    Pane emptyFlower = new Pane();
                    emptyFlower.setPrefSize(150,150);
                    grid.add(emptyFlower, c, r);
                }
            }
        }

        // Position grid
        VBox g = new VBox(grid);
        StackPane.setAlignment(g, Pos.BOTTOM_CENTER);

        // Add elements to screen
        vbox.getChildren().addAll(pos);
        pane.getChildren().addAll(bgView, g, vbox);

        return pane;
    }
}