package com.example.task12;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Grass implements Item {
    public void draw(GraphicsContext gc, Canvas canvas) {
        ParametersSingleton singleton = ParametersSingleton.getInstance();
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();
        double lineWidth = singleton.getLineWidth();
        gc.setLineWidth(lineWidth);

        // Отрисовка острозубчатой травы
        gc.setFill(Color.DARKGREEN);
        double grassHeight = 10; // Высота травы
        double grassSpacing = 5; // Расстояние между зубцами
        double y = canvasHeight - grassHeight; // Начальная нижняя координата травы

        while (y >= (canvasHeight - 20)) { // Изменено условие, чтобы трава росла вниз до нижней границы
            double[] xPoints = {0, canvasWidth / 2, canvasWidth};
            double[] yPoints = {y, y + grassHeight, y}; // Изменено здесь
            gc.fillPolygon(xPoints, yPoints, 3);
            y -= grassSpacing;
        }

        System.out.println("Отрисована трава");
    }
}
