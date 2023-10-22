package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triug extends  Shapes{
    double x1, x2, x3;
    double y1, y2, y3;

    public void Draw(GraphicsContext gr, Double pointX, Double pointY, int border) {
        //gr.clearRect(0, 0, 500.0, 400.0); построение на очищенной канве
        gr.setFill(shapeColor);
        gr.fillPolygon(new double[]{pointX+x1-180-30, pointX, pointX+x3-140}, new double[]{pointY+y1-70, pointY, pointY+y3-120}, 3);

        if (border >= 1) {
            gr.setStroke(shapeColorBorder);
            gr.strokePolygon(new double[]{pointX+x1-180-30, pointX, pointX+x3-140}, new double[]{pointY+y1-70, pointY, pointY+y3-120}, 3);
            gr.setLineWidth(border);
        }

    }

    public double area(){
        double a = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
        double b = Math.sqrt(Math.pow((x1-x3),2)+Math.pow((y1-y3),2));
        double c = Math.sqrt(Math.pow((x3-x2),2)+Math.pow((y3-y2),2));
        double p = (a + b + c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public String toString() {
        return "Треугольник";
    }

    public Triug(Color color, double x1, double y1, double x2, double y2, double x3, double y3 ) { // calling Shape constructor
        super(color);
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }
}
