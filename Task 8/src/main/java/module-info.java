module com.example.decorator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.Task8 to javafx.fxml;
    exports com.example.Task8;
}