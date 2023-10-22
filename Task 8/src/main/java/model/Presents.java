package model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Presents extends TreeDecorator{
    public Presents(ChristmasTree tree) {
        super(tree);
    }

    public void draw(Pane panePresent) {
        super.draw(panePresent);
        drawwithPresents(panePresent);
    }

    private void drawwithPresents(Pane panePresent) {

        Rectangle present1 = new Rectangle();
        present1.setX(115);
        present1.setY(370);
        present1.setWidth(70);
        present1.setHeight(50);
        present1.setArcWidth(20);
        present1.setArcHeight(20);
        present1.setFill(Color.DEEPPINK);

        Rectangle present2 = new Rectangle();
        present2.setX(270);
        present2.setY(400);
        present2.setWidth(40);
        present2.setHeight(20);
        present2.setFill(Color.DARKGREY);

        Rectangle present3 = new Rectangle();
        present3.setX(320);
        present3.setY(369);
        present3.setWidth(30);
        present3.setHeight(50);
        present3.setFill(Color.ORANGERED);

        panePresent.getChildren().addAll(present1, present2, present3);
    }
}
