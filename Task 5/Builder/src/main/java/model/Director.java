package model;


public class Director {
    public Indicator build(IndicatorBuilder builder) {
        builder.buildCircles();
        builder.buildLines();
        return builder.getIndicator();
    }
}
