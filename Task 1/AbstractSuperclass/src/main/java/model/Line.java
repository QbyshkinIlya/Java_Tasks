package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shapes {
    double x1, x2;
    double y1, y2;

    public void Draw(GraphicsContext gr) {
        gr.setStroke(ShapeColor);
        gr.strokeLine(x1, y1, x2, y2);
    }

    public double area(){
        return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
    }

    public String toString() {
        return "Цвет линии " + super.ShapeColor + ",а длинна линии равна: " + area();
    }

    public Line(Color color, double x1, double y1, double x2, double y2) {
// calling Shape constructor
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

}
