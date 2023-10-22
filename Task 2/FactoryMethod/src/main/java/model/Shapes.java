package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shapes {
    protected Color shapeColor;

    public abstract String toString();

    public abstract void Draw(GraphicsContext gr);

    public abstract double area();

    public Shapes(Color color) {
        System.out.println("Shape constructor called");
        this.shapeColor = color;
    }

    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }

    public Color getShapeColor() {
        return shapeColor;
    }
}

