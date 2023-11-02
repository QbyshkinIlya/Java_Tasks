package com.example.task12;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public interface Item {
    void draw(GraphicsContext gc, Canvas canvas);
}
