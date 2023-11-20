package com.example.finalkursovoy.DataBase;

import java.sql.*;

/**
 *Класс для доступа к базе данных
 * @author je1rei
 */
public class DatabaseConnector {
    private static final String URL = "jdbc:h2:tcp://localhost/~/test"; // Путь к базе данных H2
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static final DatabaseConnector instance = new DatabaseConnector();

    public static DatabaseConnector getInstance() {
        return instance;
    }

    /**
     * Метод для получение коннекта к базе данных H2
     * @return Коннект к базе данных H2
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Создание таблиц
     */
    public static void createTables(){
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (Statement statement = connection.createStatement()) {
                // SQL-запрос для создания таблицы поездки
                String createTableTrip = "CREATE TABLE IF NOT EXISTS trip ("
                        + "id INT AUTO_INCREMENT PRIMARY KEY,"
                        + "start_point VARCHAR(255),"
                        + "end_point VARCHAR(255),"
                        + "distance DOUBLE,"
                        + "time_in_hours DOUBLE,"
                        + "avg_speed DOUBLE,"
                        + "people_count INT,"
                        + "fuel_consumption DOUBLE,"
                        + "fuel_needed DOUBLE,"
                        + "fuel_cost DOUBLE,"
                        + "food_cost DOUBLE,"
                        + "total_cost DOUBLE"
                        + ")";
                statement.executeUpdate(createTableTrip);

                System.out.println("Создана таблица поездок!");

                String createTableCity = "CREATE TABLE IF NOT EXISTS city ("
                        + "id INT AUTO_INCREMENT PRIMARY KEY,"
                        + "name VARCHAR(255),"
                        + "latitude DOUBLE,"
                        + "longitude DOUBLE"
                        + ")";
                statement.executeUpdate(createTableCity);

                System.out.println("Создана таблица городов!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для заполнения таблицы Trip
     * @param startPoint
     * @param endPoint
     * @param distance
     * @param timeInHours
     * @param avgSpeed
     * @param peopleCount
     * @param fuelConsumption
     * @param fuelNeeded
     * @param fuelCost
     * @param foodCost
     * @param totalCost
     */
    public static void insertTripData(String startPoint, String endPoint, double distance, double timeInHours,
                                      double avgSpeed, int peopleCount, double fuelConsumption, double fuelNeeded,
                                      double fuelCost, double foodCost, double totalCost) {
        try (Connection connection = getConnection()) {
            String insertDataQuery = "INSERT INTO trip (start_point, end_point, distance, time_in_hours, avg_speed, " +
                    "people_count, fuel_consumption, fuel_needed, fuel_cost, food_cost, total_cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataQuery)) {
                preparedStatement.setString(1, startPoint);
                preparedStatement.setString(2, endPoint);
                preparedStatement.setDouble(3, distance);
                preparedStatement.setDouble(4, timeInHours);
                preparedStatement.setDouble(5, avgSpeed);
                preparedStatement.setInt(6, peopleCount);
                preparedStatement.setDouble(7, fuelConsumption);
                preparedStatement.setDouble(8, fuelNeeded);
                preparedStatement.setDouble(9, fuelCost);
                preparedStatement.setDouble(10, foodCost);
                preparedStatement.setDouble(11, totalCost);

                preparedStatement.executeUpdate();
                System.out.println("Данные успешно добавлены в таблицу поездок!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для заполнения таблицы City
     * @param name
     * @param latitude
     * @param longitude
     */
    public static void insertCityData(String name, double latitude, double longitude) {
        try (Connection connection = getConnection()) {
            String insertDataQuery = "INSERT INTO city (name, latitude, longitude) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataQuery)) {
                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, latitude);
                preparedStatement.setDouble(3, longitude);

                preparedStatement.executeUpdate();
                System.out.println("Данные успешно добавлены в таблицу городов!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
