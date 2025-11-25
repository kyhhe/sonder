package cpen221A.sonder;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.*;

public class GardenScreen extends AbstractScreen {
    private GardenLogic gardenLogic = new GardenLogic();
    /**
     * Creates the screen for displaying the garden.
     *
     * @param main the main application which displays the screen
     */
    public GardenScreen(MainApplication main) {
        super(main);
        gardenLogic.loadGarden();
        System.out.println(gardenLogic.getGarden()); //debug
    }

    @Override
    protected Parent createRoot() {
        //Preventing null field when AbstractScreen called method
        if (gardenLogic == null) {
            gardenLogic = new GardenLogic();
            gardenLogic.loadGarden();
        }

        // Initialize Screen elements
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        Button backButton = createButton("menu");
        BorderPane pos = new BorderPane();
        pos.setLeft(backButton);
        pos.setPadding(new Insets(10));

        // Button actions
        backButton.setOnAction(e -> main.showMainMenu());

        // Background
        ImageView bgView = new ImageView(new Image(
                Objects.requireNonNull(getClass().getResource("/ScreenImages/Garden.png")).toExternalForm()
        ));
        bgView.setFitWidth(1024);
        bgView.setFitHeight(768);
        bgView.setPreserveRatio(false);

        // Garden spacing
        GridPane grid = new GridPane();
        grid.setHgap(30);
        grid.setVgap(12);
        grid.setPadding(new Insets(270,0,0,75));

        // Load flowers
        List<List<Flower>> garden = gardenLogic.getGarden();
        for (int r = 0; r < garden.size(); r++) {
            for (int c = 0; c < garden.get(r).size(); c++) {
                Flower f = garden.get(r).get(c);

                if (f != null && f.getImagePath() != null) {
                    URL url = getClass().getResource(f.getImagePath());
                    System.out.printf("url:" + url);//debug

                    ImageView flowerView = new ImageView(new Image(
                            Objects.requireNonNull(getClass().getResource(f.getImagePath())).toExternalForm()));
                    flowerView.setFitHeight(150);
                    flowerView.setFitWidth(150);
                    grid.add(flowerView, c, r);
                } else {
                    Pane emptyFlower = new Pane();
                    emptyFlower.setPrefSize(150,150);
                    grid.add(emptyFlower, c, r);
                }
            }
        }

        VBox g = new VBox(grid);

        // Add elements to screen
        StackPane.setAlignment(g, Pos.BOTTOM_CENTER);
        vbox.getChildren().addAll(pos);
        pane.getChildren().addAll(bgView, g, vbox);

        return pane;
    }
}