package com.example.task12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Canvas canvas;

    @FXML
    private Button drawButton;

    @FXML
    private void initialize() {
        drawButton.setOnAction(this::drawPicture);
    }

    private void drawPicture(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        ParametersSingleton singleton = ParametersSingleton.getInstance();

        singleton.setColor(Color.DARKGREY); // Задайте нужный цвет
        singleton.setLineWidth(5); // Задайте нужную толщину линии

        ImageBuilder builder = new SimpleImageBuilder();
        Director director = new Director();

        director.build(builder, gc, canvas);


        Image image = builder.getImage();
        image.draw(gc, canvas, singleton);
    }

}
