package cpen221A.sonder;

import cpen221A.sonder.TaskScreens.Task4Screen;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import org.controlsfx.control.spreadsheet.Grid;

import java.io.File;
import java.net.URL;
import java.util.*;

public class GardenScreen extends AbstractScreen{
    private GardenLogics gardenLogic = new GardenLogics();
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
            gardenLogic = new GardenLogics();
            gardenLogic.loadGarden();
        }
        // Initialize Screen elements
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        StackPane pane = new StackPane();

        // Screen elements
        //Label title = createTitle("garden");
        //title.setStyle("-fx-text-fill: #FFFFFF");
        Button backButton = createButton("menu");

        // Layout
        BorderPane pos = new BorderPane();
        pos.setLeft(backButton);
        //pos.setCenter(title);
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

        // garden spacing
        GridPane grid = new GridPane();
        grid.setHgap(30);
        grid.setVgap(15);
        grid.setPadding(new Insets(250,0,0,75));

        // load flowers
        List<List<Flower>> garden = gardenLogic.getGarden();
        for(int r=0;r<garden.size();r++){
            for(int c=0; c<garden.get(r).size();c++){
                Flower f = garden.get(r).get(c);
                if(f!=null && f.getImagePath()!= null){
                    URL url=getClass().getResource(f.getImagePath());
                    System.out.printf("url:"+url);//debug

                    ImageView fImage = new ImageView(new Image(
                            Objects.requireNonNull(getClass().getResource(f.getImagePath())).toExternalForm()));
                    fImage.setFitHeight(150);
                    fImage.setFitWidth(150);
                    grid.add(fImage, c, r);
                }else{
                    Pane emptyFlower = new Pane();
                    emptyFlower.setPrefSize(150,150);
                    grid.add(emptyFlower,c,r);
                }
            }
        }
        VBox g = new VBox(grid);
        grid.setPrefWidth(1024);
        grid.setPrefHeight(220);
        g.setAlignment(Pos.CENTER);

        // Add elements to screen
        StackPane.setAlignment(g, Pos.BOTTOM_CENTER);
        vbox.getChildren().addAll(pos);
        pane.getChildren().addAll(bgView, g, vbox);

        return pane;
    }

}
