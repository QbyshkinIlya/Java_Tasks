package com.example.finalkursovoy;

import com.example.finalkursovoy.DataBase.DatabaseConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * класс для запуска программы JavaFX
 */
public class HelloApplication extends Application {
    /**
     * Старт программы
     * @param stage
     * @throws IOException
     * @throws SQLException
     */
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        DatabaseConnector.getConnection(); // коннект к бд
        DatabaseConnector.createTables(); // создание таблиц

        stage.setTitle("Калькулятор поездки на машине");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main - метод для запуска программы после нажатия на кнопку RUN в IDE
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}