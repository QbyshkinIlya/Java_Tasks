package model;


import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Signal extends Text implements IObserver {
    public int count = 0;
    public  int seconds = 0;
    public int minutes = 0;
    @Override
    public void update() {
        count++;
        minutes = (int)Math.floor(count / 60);
        seconds = (int)Math.floor(count % 60);

        this.setText(String.valueOf("Глобальное время сервера: " + minutes + " минут " + seconds + " секунд"));
        this.setFont(new Font(20));
        this.setWrappingWidth(1200);
        this.setTextAlignment(TextAlignment.CENTER);
    }
}
