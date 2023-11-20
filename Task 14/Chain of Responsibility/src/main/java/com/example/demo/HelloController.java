package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Player;
import model.SlotMachine;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public Label LabelGo, statusLabel, moneyAutomat, moneyofPlayer;
    @FXML
    public ImageView Ris1, Ris2, Ris3;
    public Label moneyofAutomat;
    private SlotMachine slotMachine;
    private Player player1;

    public void onGo(ActionEvent actionEvent) {
        Image image1 = new Image("kor.png");
        Ris1.setImage(image1);
        Ris2.setImage(image1);
        Ris3.setImage(image1);
        UpdatingPointsOnScreen();
        LabelGo.setText("Выберите коробку!");
    }

    public void onEnd(ActionEvent actionEvent) {

        LabelGo.setText("Игра окончена!");
    }

    public void OnMouseClickImg(MouseEvent event) {
        if (player1.getCoins() <= 0) {
            LabelGo.setText("Вам не хватает монет, чтобы продолжить! \n Добавьте монеты, или завершите игру.");
            statusLabel.setVisible(false);
            return;
        }

        int result = slotMachine.play(player1);
        UpdatingPointsOnScreen();
        if (result >= 7) {
            statusLabel.setVisible(true);
            //statusLabel.setStyle("-fx-text-fill: color");
            statusLabel.setTextFill(Color.color(0, 1, 0));
            statusLabel.setText("Вы выиграли!");
        } else {
            statusLabel.setVisible(true);
            statusLabel.setTextFill(Color.color(1, 0, 0));
            statusLabel.setText("Вы проиграли!");
        }
    }

    public void addMoney(ActionEvent actionEvent) {
        player1.addCoins(50);
        UpdatingPointsOnScreen();
    }

    private void UpdatingPointsOnScreen() {
        moneyofPlayer.setText(String.valueOf(player1.getCoins()));
        moneyofAutomat.setText(String.valueOf(slotMachine.getCoins()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        slotMachine = new SlotMachine(100);
        player1 = new Player(50);
        LabelGo.setText("Чтобы начать нажмите поехали");
    }
}
