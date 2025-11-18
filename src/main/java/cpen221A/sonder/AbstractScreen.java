package cpen221A.sonder;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import java.util.Objects;

/**
 * Abstract class for creating new screens
 */
public abstract class AbstractScreen {
    protected final MainApplication main;
    protected Scene scene;
    protected Parent root;

    /**
     * Creates a new screen with the specified dimensions for the app.
     * @param app app that displays this screen.
     */
    public AbstractScreen(MainApplication app) {
        this.main = app;
        this.scene = new Scene(createRoot(), 1024, 768);
        this.root = createRoot();

        // Sets keyboard inputs
        scene.setOnKeyPressed(this::onKeyPressed);

        // loads custom fonts front the CSS folder
        Font.loadFont(Objects.requireNonNull(
            MainApplication.class.getResource("/css/CaveatBrush-Regular.ttf")).toExternalForm(), 10);

        // Gets the global CSS sheet for UI
        scene.getStylesheets().add(
            Objects.requireNonNull(getClass().getResource("/css/global.css")).toExternalForm()
        );
    }

    /**
     * Creates the parent containers of the scene
     * @return the parent containers
     */
    protected abstract Parent createRoot();

    /**
     * Creates title text using the global styling
     *
     * @param text text to be displayed
     * @return title text with the appropriate styling
     */
    public Label createTitle(String text) {
        Label label = new Label(text);
        label.getStyleClass().add("title-label");
        return label;
    }

    /**
     * Creates text using the global styling
     *
     * @param text text to be displayed
     * @return text with the appropriate styling
    */
    public Label createText(String text) {
        Label label = new Label(text);
        label.getStyleClass().add("main-text");
        return label;
    }

    /**
     * Creates a button with a text button using the global styling
     *
     * @param text text to be displayed in the button
     * @return styled button with the indicated text
     */
    public Button createButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().add("button-text");
        button.setFocusTraversable(false);
        return button;
    }

    /**
     * Gets the scene created by the class
     *
     * @return the scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Returns the root of the scene
     *
     * @return the root containing the elements of the scene.
     */
    public Parent getRoot() {
        return root;
    }

    /**
     * Method to set keyboard actions. Does nothing by default. Must be overwritten by child class to
     * implement functionality.
     *
     * @param keyEvent keypress from the user
     */
    protected void onKeyPressed(javafx.scene.input.KeyEvent keyEvent) {
    }
}
