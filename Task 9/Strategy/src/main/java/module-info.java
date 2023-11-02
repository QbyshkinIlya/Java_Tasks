module com.example.task_9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task_9 to javafx.fxml;
    exports com.example.task_9;
}