package com.example.finalkursovoy;

import java.sql.ResultSet;
import com.example.finalkursovoy.DataBase.DatabaseConnector;
import com.example.finalkursovoy.openRouteService.OpenRouteServiceGeocodingCallback;
import com.example.finalkursovoy.openRouteService.OpenRouteServiceGeocodingUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.grum.geocalc.Coordinate;
import com.grum.geocalc.Point;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.sql.SQLException;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Контроллер для JavaFX
 */
public class HelloController {
    @FXML
    private Label startPointLabel;

    @FXML
    private Label endPointLabel;

    @FXML
    private Label distanceLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label speedLabel;

    @FXML
    private Label peopleLabel;

    @FXML
    private Label fuelConsumptionLabel;

    @FXML
    private Label fuelNeededLabel;

    @FXML
    private Label fuelCostLabel;

    @FXML
    private Label foodCostLabel;


    @FXML
    private Label totalCostLabel;

    @FXML
    private TextField city1Field;

    @FXML
    private TextField city2Field;

    @FXML
    private TextField avgSpeedField;

    @FXML
    private TextField fuelRateField;

    @FXML
    private TextField countPeopleField;


    private final DistanceCalculator distanceCalculator = DistanceCalculator.getInstance();

    @FXML
    private void initialize() {

    }

    /**
     * Вывод и расчет всех итоговых данных в графический интерфейс для пользователя
     */
    @FXML
    protected void calculateDistance() {
        try {
            String city1 = city1Field.getText();
            String city2 = city2Field.getText();
            String avgSpeedText = avgSpeedField.getText();
            String fuelRateText = fuelRateField.getText();
            String countPeopleText = countPeopleField.getText();

            OpenRouteServiceGeocodingUtil geocodingUtil1 = new OpenRouteServiceGeocodingUtil();
            geocodingUtil1.getCoordinates(city1, new OpenRouteServiceGeocodingCallback() {
                @Override
                public void onSuccess(double lat1, double lon1) {
                    System.out.println("Координаты 1 города: Lat=" + lat1 + ", Lon=" + lon1);

                    OpenRouteServiceGeocodingUtil geocodingUtil2 = new OpenRouteServiceGeocodingUtil();
                    geocodingUtil2.getCoordinates(city2, new OpenRouteServiceGeocodingCallback() {
                        @Override
                        public void onSuccess(double lat2, double lon2) {
                            System.out.println("Координаты 2 города: Lat=" + lat2 + ", Lon=" + lon2);

                            Point point1 = Point.at(Coordinate.fromDegrees(lat1), Coordinate.fromDegrees(lon1));
                            Point point2 = Point.at(Coordinate.fromDegrees(lat2), Coordinate.fromDegrees(lon2));
                            double avgSpeed = 60;

                            if (!avgSpeedText.isEmpty()) {
                                avgSpeed = Double.parseDouble(avgSpeedText);
                            }

                            double fuelRate = 8;

                            if (!fuelRateText.isEmpty()) {
                                fuelRate = Double.parseDouble(fuelRateText);
                            }

                            int countPeople = 1;

                            if (!countPeopleText.isEmpty()) {
                                countPeople = Integer.parseInt(countPeopleText);
                            }
                            double foodExpenses = 100;
                            double fuelCostLiter =  56.3;

                            double distanceCar = distanceCalculator.calculateDistanceVincentyCar(point1, point2); // meters
                            double finalDistance = Math.round(distanceCar / 10.0) / 100.0; // округление до одной десятой
                            double timeInHours = Math.round(finalDistance / avgSpeed); // время в часах
                            double fuelFlow = Math.round(finalDistance / 100 * fuelRate); // количество топлива на поездку
                            double fuelFlowCost = Math.round(fuelFlow * fuelCostLiter);
                            double foodExpensesAllTime = Math.round(foodExpenses * timeInHours * countPeople);

                            System.out.println("finalDistance: " + finalDistance + " км + Расходы на еду " + foodExpensesAllTime);
                            System.out.println("Time: " + timeInHours + " ч" + " Количество человек в машине " + countPeople);
                            System.out.println("avgSpeed: " + avgSpeed + " км/ч");
                            System.out.println("fuelRate: " + fuelRate + " л");
                            System.out.println("fuelFlow: " + fuelFlow + " л" + " Цена за всю поездку на бензин: " + fuelFlowCost);

                            //setLabels
                            startPointLabel.setText("Начальный пункт: " + city1);
                            endPointLabel.setText("Конечный пункт: " + city2);
                            distanceLabel.setText("Расстояние между пунктами: " + finalDistance + " км");
                            timeLabel.setText("Время в пути: " + timeInHours + " ч");
                            speedLabel.setText("Средняя скорость: " + avgSpeed + " км/ч");
                            peopleLabel.setText("Количество человек в машине: " + countPeople);
                            fuelConsumptionLabel.setText("Расход топлива на 100 км: " + fuelRate + " л");
                            fuelNeededLabel.setText("Сколько нужно бензина на всю дорогу: " + fuelFlow + " л");
                            fuelCostLabel.setText("Затраты на бензин: " + fuelFlowCost + " рублей");
                            foodCostLabel.setText("Затраты на еду: " + foodExpensesAllTime + " рублей");
                            totalCostLabel.setText("Сумма общих расходов: " + (fuelFlowCost + foodExpensesAllTime) + " рублей");

                            DatabaseConnector.insertTripData(city1, city2, finalDistance, timeInHours, avgSpeed, countPeople,
                                    fuelRate, fuelFlow, fuelFlowCost, foodExpensesAllTime, (fuelFlowCost + foodExpensesAllTime));

                            DatabaseConnector.insertCityData(city1, lat1, lon1);
                            DatabaseConnector.insertCityData(city2, lat2, lon2);
                        }

                        @Override
                        public void onError(String errorMessage) {
                            startPointLabel.setText(errorMessage);
                        }
                    });
                }

                @Override
                public void onError(String errorMessage) {
                    startPointLabel.setText(errorMessage);
                }
            });
        } catch (NumberFormatException e) {
            startPointLabel.setText("Неверный ввод.");
        }
    }

}

