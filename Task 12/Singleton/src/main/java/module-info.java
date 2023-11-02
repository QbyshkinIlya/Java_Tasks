module com.example.task12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task12 to javafx.fxml;
    exports com.example.task12;
}