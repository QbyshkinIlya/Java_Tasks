package model;

import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class Text_time extends Text implements IObserver{
    @Override
    public void update() {
        System.out.println();
        //this.setText(String.valueOf());
    }
}