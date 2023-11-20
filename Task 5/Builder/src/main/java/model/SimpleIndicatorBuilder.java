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

    }

    @Override
    public Indicator getIndicator() {
        return indicator;
    }

}
