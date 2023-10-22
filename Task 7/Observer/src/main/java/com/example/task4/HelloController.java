package com.example.task4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.*;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import model.Indicator.ServerIndicator;
import model.SlaidWoy.ImageCollection;
import model.SlaidWoy.Iterator;
import model.SlaidWoy.SlaidWoy;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    public ImageView pleer;
    @FXML
    public ImageCollection imgs = new ImageCollection();
    @FXML
    public Iterator iter_main = imgs.getIterator();
    @FXML
    public Timeline timeline = new Timeline();
    public TextField taim;
    public Pane pane_SW;
    public Pane pane_SI;
    public VBox boxtext;


    private TimeServer timeServer = new TimeServer();

    private Text_time text_time = new Text_time();

    private Signal signal = new Signal();

    private SlaidWoy sw = new SlaidWoy();

    private ServerIndicator si = new ServerIndicator();


    public void onNext(ActionEvent actionEvent) {
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.next();
            pleer.setImage(name);
        }
    }

    public void onBack(ActionEvent event) {
        if (iter_main.hasPreview()) {
            Image name = (Image) iter_main.preview();
            pleer.setImage(name);
        }
    }

    public void start(ActionEvent event) {
        timeServer.attach(sw);
    }

    public void onStop(ActionEvent event) {
        //timeline.stop();
        timeServer.detach(sw);
        //pane_SW.getChildren().clear();
    }

    public void startTaimer(ActionEvent event) {
        timeServer.attach(si);
        //pane_SI.getChildren().add(si);
    }

    public void taimer(KeyEvent keyEvent) {
        if(keyEvent.getCode()== KeyCode.ENTER){
        timeline.setCycleCount(Timeline.INDEFINITE); //количество повторов
        timeline.getKeyFrames().add(new KeyFrame(new Duration(Double.parseDouble(taim.getText())), new EventHandler() {
            @Override
            public void handle(Event event) {
                if (iter_main.hasNext()) {
                    Image name = (Image) iter_main.next();
                    pleer.setImage(name);
                }
            }
        }));
        timeline.play();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeServer.attach(signal);
        boxtext.getChildren().add(signal);
        pane_SW.getChildren().add(sw);
        pane_SI.getChildren().add(si);
    }


}