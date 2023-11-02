package com.example.task12;
import javafx.scene.paint.Color;

public class ParametersSingleton {
    private static ParametersSingleton instance;
    private Color color;
    private int lineWidth;

    private ParametersSingleton() {
        this.color = Color.DARKGREY;
        this.lineWidth = 5;
    }

    public static ParametersSingleton getInstance() {
        if (instance == null) {
            instance = new ParametersSingleton();
        }
        return instance;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }
}

