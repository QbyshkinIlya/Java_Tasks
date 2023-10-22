package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class _5Gon extends Shapes{
    double CanvasHeight;
    double CanvasWidth;
    double Radius = 55;


    public void Draw(GraphicsContext gr, Double pointX, Double pointY, int border) {
        //gr.clearRect(0, 0, 500.0, 400.0); построение на очищенной канве
        gr.setFill(shapeColor);

        double[] x_cords = new double[5];
        double[] y_cords = new double[5];

        for (int i = 0; i < 5; ++i) {
            x_cords[i] = (Radius * Math.cos(2 * Math.PI * i / 5) + (((CanvasWidth/5)-90) / 2)) + pointX;
            y_cords[i] = (Radius * Math.sin(2 * Math.PI * i / 5) + (((CanvasHeight/5)+20) / 2)) + pointY;
        }
        gr.fillPolygon(x_cords, y_cords, x_cords.length);

        if (border >= 1) {
            gr.setStroke(shapeColorBorder);
            gr.strokePolygon(x_cords, y_cords, x_cords.length);
            gr.setLineWidth(border);
        }

    }

    public double area(){
        return 0.5 * Math.pow(Radius,2) * 5 * Math.sin(360.0/5) ;
    }

    public String toString() {
        return "Пятиугольник";
    }

    public _5Gon(Color color, double CanvasHeight, double CanvasWidth) { // calling Shape constructor
        super(color);
        this.CanvasHeight = CanvasHeight;
        this.CanvasWidth = CanvasWidth;
    }
}
