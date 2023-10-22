package com.example.task3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Builders.BMI;

public class HelloController {

    @FXML
    private TextField tfves;
    @FXML
    private TextField tfrost;

    @FXML
    private Label labeltext;

    @FXML
    protected void onHelloButtonClick() {
        BMI bmi = new BMI();

        float ves = Float.parseFloat(tfves.getText());
        float height = Float.parseFloat(tfrost.getText());

        float result = (ves/(height*height)) * 10000;


        labeltext.setText(String.format("%.1f",result));
    };


}