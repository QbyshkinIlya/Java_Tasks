package model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import model.ChristmasTree;

public class ChristmasTreeImpl implements ChristmasTree {
    public void draw(Pane pane) {
        Polygon tree = new Polygon();
        tree.setFill(Color.GREEN);
        tree.getPoints().addAll(new Double[] {239.0, 93.0, 120.0, 360.0, 359.0, 360.0,});

        tree.setStroke(Color.BLACK);
        tree.setStrokeWidth(1);
        pane.getChildren().addAll(tree);

        Rectangle stvol = new Rectangle();
        stvol.setX(210);
        stvol.setY(361);
        stvol.setWidth(58);
        stvol.setHeight(60);
        stvol.setFill(Color.BROWN);
        pane.getChildren().addAll(stvol);
    }
}
