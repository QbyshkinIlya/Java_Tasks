package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shapes implements Cloneable {
    protected Color shapeColor;
    protected Color shapeColorBorder;


    public abstract String toString();

    public abstract void Draw(GraphicsContext gr, Double pointX, Double pointY, int border);

    public abstract double area();

    public Shapes(Color color) {
        System.out.println("Shape constructor called");
        this.shapeColor = color;
    }
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();   }
        return clone; }

    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }

    public void setShapeColorBorder(Color shapeColorBorder){this.shapeColorBorder = shapeColorBorder;}

}

