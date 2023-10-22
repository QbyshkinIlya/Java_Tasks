package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class _5Gon extends Shapes{
    double CanvasHeight;
    double CanvasWidth;
    double Radius = 110;

    public void Draw(GraphicsContext gr) {
        gr.clearRect(0, 0, 500.0, 400.0);
        gr.setFill(ShapeColor);

        double[] x_cords = new double[5];
        double[] y_cords = new double[5];

        for (int i = 0; i < 5; ++i) {
            x_cords[i] = Radius * Math.cos(2 * Math.PI * i / 5) + (CanvasWidth / 2);
            y_cords[i] = Radius * Math.sin(2 * Math.PI * i / 5) + (CanvasHeight / 2);
        }

        gr.fillPolygon(x_cords, y_cords, x_cords.length);
    }

    public double area(){
        return 0.5 * Math.pow(Radius,2) * 5 * Math.sin(360.0/5) ;
    }

    public String toString() {
        return "Цвет пятиугольника " + super.ShapeColor + ",а площадь равна: " + area();
    }

    public _5Gon(Color color, double CanvasHeight, double CanvasWidth) {
// calling Shape constructor
        super(color);
        this.CanvasHeight = CanvasHeight;
        this.CanvasWidth = CanvasWidth;
    }
}
