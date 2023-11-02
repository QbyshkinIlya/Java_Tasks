package com.example.task12;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class SimpleImageBuilder implements ImageBuilder {
    private Image image;

    public SimpleImageBuilder(){
        this.image = new Image();
    }

    public void buildHouse(GraphicsContext gc, Canvas canvas) {
        this.image.setHouse(new House());
    }

    public void buildGrass(GraphicsContext gc, Canvas canvas) {
        this.image.setGrass(new Grass());
    }

    public void buildTree(GraphicsContext gc, Canvas canvas) {
        this.image.setTree(new Tree());
    }

    public Image getImage() {
        return this.image;
    }
}
