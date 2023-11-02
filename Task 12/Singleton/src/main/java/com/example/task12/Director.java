package com.example.task12;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
public class Director {
    public void build(ImageBuilder builder, GraphicsContext gc, Canvas canvas) {
            builder.buildTree(gc, canvas);
            builder.buildHouse(gc, canvas);
            builder.buildGrass(gc, canvas);
    }
}
