package model;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Worker extends Colleague {
    private int NUMBER = 5;//константа NUMBER изменена на private для указания того что это поле экземпляра

    public Worker(Mediator mediator) {
        super(mediator);
    }

    public void setTest(int n) {
        NUMBER = n;
    }

    @Override
    public void notifyColleague(ArrayList<Qweston> message) {
        VBox qwpane = new VBox();
        Random random = new Random();
        for (int iqw = 0; iqw < NUMBER && iqw < message.size(); iqw++) {
            Label qwfield = new Label();
            qwfield.textProperty().bind(message.get(iqw).questionProperty());
            qwpane.getChildren().add(qwfield);
            Separator separator = new Separator();
            separator.setMaxWidth(20);
            qwpane.getChildren().add(separator);

            CheckBox qwfield1 = new CheckBox();
            CheckBox[] qwfieldi = new CheckBox[3];
            int k = random.nextInt(message.get(iqw).getAnswerGood().size());
            qwfield1.textProperty().bind(message.get(iqw).getAnswerGood().get(k));
            qwfield1.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                BackgroundFill background_fill = new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY);
                if (new_val) {
                    qwfield1.setBackground(new Background(background_fill));
                    for (int i = 0; i < 3; i++) {
                        qwfieldi[i].setSelected(false);
                    }
                }
            });

            int[] count = new int[message.get(iqw).getBadAnswer().size()];

            for (int i = 0; i < message.get(iqw).getBadAnswer().size(); i++) {
                count[i] = 1;
            }
            for (int i = 0; i < 3; i++) {
                k = random.nextInt(message.get(iqw).getBadAnswer().size());
                if (count[k] == 1) {
                    CheckBox cb = qwfieldi[i] = new CheckBox();
                    qwfieldi[i].textProperty().bind(message.get(iqw).getBadAnswer().get(k));
                    qwfieldi[i].selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                        BackgroundFill background_fill = new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY);
                        if (new_val) {
                            qwfield1.setSelected(false);
                            for (int j = 0; j < 3; j++) {
                                if (qwfieldi[j] != cb) {
                                    qwfieldi[j].setSelected(false);
                                }
                            }
                            cb.setBackground(new Background(background_fill));
                        }
                    });
                    count[k] = 0;
                } else {
                    i--;
                }
            }
            k = random.nextInt(4);
            for (int i = 0; i < 3; i++) {
                if (i != k) {
                    qwpane.getChildren().add(qwfieldi[i]);
                } else {
                    qwpane.getChildren().add(qwfield1);
                }
            }
            if (k == 3) {
                qwpane.getChildren().add(qwfield1);
            } else {
                qwpane.getChildren().add(qwfieldi[k]);
            }
        }
        mediator.setView(qwpane);
    }

    public void receive(ArrayList<Qweston> message) {
        ArrayList<Qweston> currenttest = new ArrayList<>();
        ArrayList<Qweston> test = new ArrayList<>(message);
        for (int i = 0; i < NUMBER && i < test.size(); i++) {int index = (int) (Math.random() * test.size());
            if (index == test.size()) {
                index--;
            }
            currenttest.add(test.get(index));
            test.remove(index);
        }
        super.receive(currenttest);
    }
}