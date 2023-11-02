package com.example.task12;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Tree implements Item {
    public void draw(GraphicsContext gc, Canvas canvas) {
            ParametersSingleton singleton = ParametersSingleton.getInstance();

            gc.setFill(singleton.getColor());
            gc.setLineWidth(singleton.getLineWidth());
            gc.fillRect(400, 350, 20, 75);
            gc.setFill(Color.LIGHTGREEN);
            double[] xPoints = {350, 400, 470};
            double[] yPoints = {365, 240, 365};
            gc.fillPolygon(xPoints, yPoints, 3);
            System.out.println("Отрисована ель");
    }
}
