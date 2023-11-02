module com.example.task17sync {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.task17sync to javafx.fxml;
    exports com.example.task17sync;
}