module cpen221A.sonder {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires java.desktop;
    requires com.google.gson;
    requires javafx.base;

    opens cpen221A.sonder to javafx.fxml, com.google.gson;
    exports cpen221A.sonder;
}