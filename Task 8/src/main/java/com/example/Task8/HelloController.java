package com.example.Task8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import model.*;

public class HelloController {
    @FXML
    public Pane paneLight;
    public Pane panePresent;
    public Pane paneTree;
    public Pane paneStar;

    @FXML
    public void initialize() {
        paneTree.toFront();
        ChristmasTree tree = new ChristmasTreeImpl();
        tree.draw(paneTree);

    }

    public void addLights(ActionEvent actionEvent) {
        paneLight.toFront();
        ChristmasTree tree = new Girland(new ChristmasTreeImpl());
        tree.draw(paneLight);
    }

    public void addPresents(ActionEvent actionEvent) {
        panePresent.toFront();
        ChristmasTree tree = new Presents(new ChristmasTreeImpl());
        tree.draw(panePresent);
    }

    public void addStar(ActionEvent actionEvent) {
        paneStar.toFront();
        ChristmasTree tree = new Star(new ChristmasTreeImpl());
        tree.draw(paneStar);
    }

    public void addAll(ActionEvent actionEvent) {
        paneTree.toFront();
        ChristmasTree presents = new Presents(new ChristmasTreeImpl());
        presents.draw(paneTree);

        ChristmasTree star = new Star(new ChristmasTreeImpl());
        star.draw(paneTree);

        ChristmasTree girland = new Girland(new ChristmasTreeImpl());
        girland.draw(paneLight);
        paneLight.toFront();
    }

    public void del(ActionEvent actionEvent) {

        paneLight.getChildren().clear();
        paneStar.getChildren().clear();
        panePresent.getChildren().clear();
        paneTree.getChildren().clear();
        ChristmasTree tree = new ChristmasTreeImpl();
        tree.draw(paneTree);
    }

    public void addSandG(ActionEvent actionEvent) {

        paneTree.toFront();
        ChristmasTree tree =  new Girland(new Star(new ChristmasTreeImpl()));
        tree.draw(paneTree);


    }
}