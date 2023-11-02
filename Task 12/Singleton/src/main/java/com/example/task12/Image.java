package com.example.task12;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Image {
    private House house;
    private Grass grass;
    private Tree tree;

    public void setHouse(House house) {
        this.house = house;
    }

    public void setGrass(Grass grass) {
        this.grass = grass;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public void draw(GraphicsContext gc, Canvas canvas, ParametersSingleton singleton) {
        tree.draw(gc, canvas);
        house.draw(gc, canvas);
        grass.draw(gc, canvas);
    }
}
