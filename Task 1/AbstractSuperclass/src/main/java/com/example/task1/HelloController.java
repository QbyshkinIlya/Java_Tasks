package com.example.task1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Line;
import model.Rectagle;
import model.Triug;
import model._5Gon;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    private Canvas my_canvas;
    @FXML
    private GraphicsContext gr;

    @FXML
    public void onLineClick1(ActionEvent event) {
        gr.clearRect(0, 0, my_canvas.getHeight(), my_canvas.getHeight());

        Line line = new Line(Color.RED, 100.0, 130, 250, 130);
        line.Draw(gr);
        System.out.println(line.toString());
    }

    @FXML
    public void onRectClick1(ActionEvent event) {
        gr.clearRect(0, 0, my_canvas.getHeight(), my_canvas.getHeight());

        Rectagle rect = new Rectagle(Color.BLUE, 200, 200);
        rect.Draw(gr);
        System.out.println(rect.toString());
    }

    @FXML
    public void onTriugClick1(ActionEvent event) {
        gr.clearRect(0, 0, my_canvas.getHeight(), my_canvas.getHeight());

        Triug tr = new Triug(Color.GREEN, 300, 100, 80, 100,180,200);
        tr.Draw(gr);
        System.out.println(tr.toString());
    }

    @FXML
    public void on5GonClick1(ActionEvent event) {
        gr.clearRect(0, 0, my_canvas.getHeight(), my_canvas.getHeight());

        _5Gon pl = new _5Gon(Color.GOLD, my_canvas.getHeight(), my_canvas.getWidth());
        pl.Draw(gr);
        System.out.println(pl.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gr = my_canvas.getGraphicsContext2D();
    }
}