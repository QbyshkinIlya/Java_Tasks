package com.example.task12;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.application.Platform;

public class House implements Item {
    public void draw(GraphicsContext gc, Canvas canvas) {
        Platform.runLater(() -> {
        ParametersSingleton singleton = ParametersSingleton.getInstance();

        gc.setFill(singleton.getColor());
        gc.fillRect(30, 200, 200, 250);
        gc.setFill(Color.RED);
        gc.fillRect(120, 250, 60, 60);
        gc.setFill(Color.RED);
        double[] xPoints = {20, 130, 240};
        double[] yPoints = {210, 100, 210};
        gc.fillPolygon(xPoints, yPoints, 3);
        System.out.println("Отрисован дом");
        });
    }
}
