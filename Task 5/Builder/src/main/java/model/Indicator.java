package model;

import com.example.task5_stroitel.HelloController;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Indicator extends Pane {

    public void setLines(Lines lines) {
        getChildren().add(lines);
    }

    public void setCircles(Circles circles) {
        getChildren().add(circles);
    }

    private Double textField;
    RotateTransition rotateTransition = new RotateTransition();

    public void getTime(Double textField) {
        this.textField = textField;
    }

    public void update(Lines lines){
        lines.setStroke(Color.BLUE);
        rotateTransition.setDuration(Duration.seconds(textField));
        rotateTransition.setNode(lines);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                getChildren().remove(lines);
            }
        });
    }


}
