package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shapes {
    double x1, x2;
    double y1, y2;

    public void Draw(GraphicsContext gr, Double pointX, Double pointY, int border ) {
        //gr.clearRect(0, 0, 500.0, 400.0); построение на очищенной канве
        gr.setStroke(shapeColor);
        gr.strokeLine(pointX, pointY, pointX+(x2/5), pointY);
        gr.setLineWidth(border);
    }

    public double area(){
        return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
    }

    public String toString() {
        return "Линия" + shapeColor;
    }

    public Line(Color color, double x1, double y1, double x2, double y2) { // calling Shape constructor
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
