module com.example.task2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task6 to javafx.fxml;
    exports com.example.task6;
}