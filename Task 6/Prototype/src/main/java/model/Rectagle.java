package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectagle extends Shapes {
    double length;
    double height;

    public void Draw(GraphicsContext gr, Double pointX, Double pointY, int border) {
        //gr.clearRect(0, 0, 500.0, 400.0); построение на очищенной канве
        gr.setFill(shapeColor);
        gr.fillRect(pointX, pointY, length/5, height/5);

        if (border >= 1) {
            gr.setStroke(shapeColorBorder);
            gr.strokeRect(pointX, pointY, length/5, height/5);
            gr.setLineWidth(border);
        }

    }

    public double area(){
        return length * height;
    }

    public String toString() {
        return "Квадрат";
    }

    public Rectagle(Color color, double length, double height) { // calling Shape constructor
        super(color);
        this.length = length;
        this.height = height;
    }
}
