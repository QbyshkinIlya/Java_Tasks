module com.example.task5_stroitel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task5_stroitel to javafx.fxml;
    exports com.example.task5_stroitel;
    exports model;
    opens model to javafx.fxml;
}