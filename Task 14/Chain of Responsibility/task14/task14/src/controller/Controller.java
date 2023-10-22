package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Player;
import model.SlotMachine;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private SlotMachine slotMachine;
    private Player currentPlayer;

    @FXML
    private GraphicsContext gc;
    @FXML
    private Pane paneMain;
    @FXML
    private Canvas myCanvas;
    @FXML
    private ImageView imgView1, imgView2, imgView3;
    @FXML
    private Label lblInfo, lblBalancePlayer, lblBalanceMachine;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = myCanvas.getGraphicsContext2D();
        slotMachine = new SlotMachine(100);
        currentPlayer = new Player(50);
        lblInfo.setText("Начните игру!");
    }

    public void OnBtnStart(ActionEvent actionEvent) {
        paneMain.setDisable(false);
        Image i = new Image("/resource/box.png");
        imgView1.setImage(i);
        imgView2.setImage(i);
        imgView3.setImage(i);
        UpdatingPointsOnScreen();
        lblInfo.setText("Выберите фишку!");
    }

    public void OnBtnEnd(ActionEvent actionEvent) {
        paneMain.setDisable(true);
        lblInfo.setText("Игра окончена!");
        imgView1.setImage(null);
        imgView2.setImage(null);
        imgView3.setImage(null);
    }

    public void OnMouseClickImg(MouseEvent event) {
        if (currentPlayer.getCoins() <= 0) {
            lblInfo.setText("Недостаточно монет! Пожалуйста, добавьте монеты.");
            return;
        }

        int result = slotMachine.play(currentPlayer);
        UpdatingPointsOnScreen();
        if (result >= 7) {
            System.out.println("Вы выиграли!");
        } else {
            System.out.println("Вы проиграли!");
        }
    }

    private void UpdatingPointsOnScreen() {
        lblBalancePlayer.setText(String.valueOf(currentPlayer.getCoins()));
        lblBalanceMachine.setText(String.valueOf(slotMachine.getCoins()));
    }
    public void MouseHover1(MouseEvent mouseEvent) {
        imgView1.setImage(new Image("/resource/money.png"));
    }

    public void MouseOff1(MouseEvent mouseEvent) {
        imgView1.setImage(new Image("/resource/box.png"));
    }


    public void MouseHover2(MouseEvent mouseEvent) {
        imgView2.setImage(new Image("/resource/money.png"));
    }

    public void MouseOff2(MouseEvent mouseEvent) {
        imgView2.setImage(new Image("/resource/box.png"));
    }
    public void MouseHover3(MouseEvent mouseEvent) {



        imgView3.setImage(new Image("/resource/money.png"));
    }

    public void MouseOff3(MouseEvent mouseEvent) {


        imgView3.setImage(new Image("/resource/box.png"));
    }
}