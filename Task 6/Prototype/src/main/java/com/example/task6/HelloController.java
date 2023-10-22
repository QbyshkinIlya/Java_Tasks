package com.example.task6;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.*;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    public ListView ListView;
    @FXML
    public TextField bordText;
    @FXML
    public ColorPicker colPicBor;
    @FXML
    public ColorPicker colPick;
    @FXML
    private Canvas my_canvas;
    @FXML
    private GraphicsContext gr;
    @FXML
    private ObservableList<Shapes> content;

    public void drawShape(MouseEvent mouseEvent) {
        int index = ListView.getSelectionModel().getSelectedIndex(); //получение индекса выбора из списка
        Shapes shapes = (Shapes) content.get(index).clone();// создание копии фигуры
        shapes.setShapeColor(colPick.getValue()); // установка цвета заполнения фигуры по значению элемента управления colorPicker
        shapes.setShapeColorBorder(colPicBor.getValue()); // цвет контура фигуры
        int border = Integer.parseInt(bordText.getText());
        shapes.Draw(gr, mouseEvent.getX(), mouseEvent.getY(), border);
    }
    public void cleanCan() {
        GraphicsContext gr = my_canvas.getGraphicsContext2D();
        gr.clearRect(0, 0, 1000, 1000);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gr = my_canvas.getGraphicsContext2D();
        Line line = new Line(Color.RED, 100.0, 130, my_canvas.getHeight(), 130);
        Rectagle rectangle = new Rectagle(Color.BLUE, my_canvas.getHeight(), my_canvas.getHeight());
        _5Gon gon5 = new _5Gon(Color.GOLD, my_canvas.getHeight(), my_canvas.getWidth());
        Triug triangle = new Triug(Color.GREEN, 300, 100, 80, 100,180,200);
        content = FXCollections.observableArrayList(gon5, rectangle, triangle, line);
        ListView.setItems(content);
        ListView.setCellFactory(new Callback<ListView<Shapes>, ListCell<Shapes>>() {
                                    @Override
                                    public ListCell<Shapes> call(ListView<Shapes> list) {
                                        return new ShapeCell();
                                    }
                                }
        );
        ListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }


}