package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectagle extends Shapes {
    double length;
    double height;

    public void Draw(GraphicsContext gr) {
        gr.setFill(shapeColor);
        gr.fillRect(85, 60, length, height);
    }

    public double area(){
        return length * height;
    }

    public String toString() {
        return "Цвет квадрата " + super.shapeColor + ",а площадь равна:" + area();
    }

    public Rectagle(Color color, double length, double height) {
// calling Shape constructor
        super(color);
        this.length = length;
        this.height = height;
    }
}
