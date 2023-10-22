module com.aplicationfx.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens com.aplicationfx.demo to javafx.fxml;
    exports com.aplicationfx.demo;
    exports com.aplicationfx.demo.model;
    opens com.aplicationfx.demo.model to javafx.fxml;
}