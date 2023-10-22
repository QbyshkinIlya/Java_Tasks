package com.aplicationfx.demo;

import com.aplicationfx.demo.model.Calculator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private ChoiceBox<Double> choiceBox;
    private Calculator calculator;
    private ObservableList list = FXCollections.observableArrayList();


    @FXML
    protected void onHelloButtonClick() {
        calculator = new Calculator();

        calculator.setPercent(Double.valueOf(choiceBox.getValue()));

        calculator.setNumber(Double.valueOf(textField1.getText()));
        textField2.setText(String.valueOf(calculator.calc()));
    }


    private void addChoiceBox() {
        list.add(3.0);
        list.add(9.0);
        list.add(15.0);

        choiceBox.getItems().addAll(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addChoiceBox();
    }
}