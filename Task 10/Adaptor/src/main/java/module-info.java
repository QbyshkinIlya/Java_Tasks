module com.example.task_10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task_10 to javafx.fxml;
    exports com.example.task_10;
}