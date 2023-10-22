package model.Indicator;

public class Director {
    public Indicator build(IndicatorBuilder builder) {
        builder.buildCircles();
        builder.buildLines();
        return builder.getIndicator();
    }
}
