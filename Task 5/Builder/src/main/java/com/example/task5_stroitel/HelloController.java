package com.example.task5_stroitel;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Director;
import model.SimpleIndicatorBuilder;
import model.Indicator;


public class HelloController {
    public Pane indPane;
    @FXML
    public TextField time;

    public TextField getTime() {
        return time;
    }



    Director direct = new Director();
    Indicator indicator = new Indicator();


    public void indicator(){
        indPane.getChildren().clear();
        indicator.getTime(Double.valueOf((time.getText())));
        direct.build(new SimpleIndicatorBuilder(indicator));
        indPane.getChildren().add(indicator);
    }

    public void taimer(KeyEvent keyEvent) {
        if(keyEvent.getCode()== KeyCode.ENTER){

        }
    }



    /*public void clear(){
        indPane.getChildren().clear();
    }*/
}
