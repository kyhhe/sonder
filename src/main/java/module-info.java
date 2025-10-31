module cpen221A.sonder {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires cpen221A.sonder;
    requires javafx.graphics;

    opens cpen221A.sonder to javafx.fxml;
    exports cpen221A.sonder;
}