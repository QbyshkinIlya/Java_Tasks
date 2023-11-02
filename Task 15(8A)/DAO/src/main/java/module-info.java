module com.example.task8a {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.task8a to javafx.fxml;

    exports com.example.task8a;
}