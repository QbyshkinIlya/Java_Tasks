package com.example.task12;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;

public interface ImageBuilder {
    void buildHouse(GraphicsContext gc, Canvas canvas);
    void buildGrass(GraphicsContext gc, Canvas canvas);
    void buildTree(GraphicsContext gc, Canvas canvas);
    Image getImage();
}
