module com.example.finalkursovoy {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires geocalc;
    requires java.desktop;
    requires com.google.gson;
    requires java.sql;

    opens com.example.finalkursovoy to javafx.fxml;
    exports com.example.finalkursovoy;
    exports com.example.finalkursovoy.openRouteService to com.google.gson;

}