package cpen221A.sonder;

import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.Objects;

/**
 * Abstract class for creating new screens
 */
public abstract class AbstractScreen {
    protected final MainApplication main;
    protected final Scene scene;

    /**
     * Creates a new screen with the specified dimensions for the app.
     * @param app app that displays this screen.
     */
    public AbstractScreen(MainApplication app) {
        this.main = app;
        this.scene = new Scene(createRoot(), 1024, 768);

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
     * Gets the scene
     * @return the scene
     */
    public Scene getScene() {
        return scene;
    }

}
