package model;

import javafx.scene.paint.Color;

public class SimpleIndicatorBuilder implements IndicatorBuilder {
    private Indicator indicator = new Indicator();

    public SimpleIndicatorBuilder(Indicator indicator){
        this.indicator = indicator;
    }

    @Override
    public void buildCircles() {
        Circles circles = new Circles();
        indicator.getChildren().add(circles);
        circles.setFill(Color.GRAY);
        circles.setStroke(Color.BLACK);
        circles.setCenterX(250);
        circles.setCenterY(200);
        circles.setRadius(100);
    }

    @Override
    public void buildLines() {
        Lines lines1 = new Lines();
        indicator.getChildren().add(lines1);
        lines1.setStroke(Color.BLUE);
        lines1.setStrokeWidth(3);
        lines1.setStartX(250);
        lines1.setStartY(300);
        lines1.setEndX(250);//конец стрелки
        lines1.setEndY(100);
        indicator.update(lines1);


       /* Lines lines2 = new Lines();
        indicator.getChildren().add(lines2);
        lines2.setStroke(Color.TRANSPARENT);
        lines2.setStrokeWidth(5);
        lines2.setStartX(250);
        lines2.setStartY(200);
        lines2.setEndX(350);//конец стрелки
        lines2.setEndY(200);

        Lines lines3 = new Lines();
        indicator.getChildren().add(lines3);
        lines3.setStroke(Color.TRANSPARENT);
        lines3.setStrokeWidth(5);
        lines3.setStartX(250);
        lines3.setStartY(200);
        lines3.setEndX(250);//конец стрелки
        lines3.setEndY(300);

        Lines lines4 = new Lines();
        indicator.getChildren().add(lines4);
        lines4.setStroke(Color.TRANSPARENT);
        lines4.setStrokeWidth(5);
        lines4.setStartX(250);
        lines4.setStartY(200);
        lines4.setEndX(150);//конец стрелки
        lines4.setEndY(200);*/

    }

    @Override
    public Indicator getIndicator() {
        return indicator;
    }

}
