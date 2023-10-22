package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shapes {
    protected Color ShapeColor;

    public abstract String toString();

    public abstract void Draw(GraphicsContext gr);

    public abstract double area();

    public Shapes(Color color) {
        System.out.println("Shape constructor called");
        this.ShapeColor = color;
    }
}

