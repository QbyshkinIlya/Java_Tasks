package model.Indicator;


import javafx.scene.layout.Pane;
import model.IObserver;

public class ServerIndicator extends Pane implements IObserver {
    Director direct = new Director();
    Indicator indicator = new Indicator();
    public  int counter = 0;
    @Override
    public void update() {
        counter++;
        if(counter % 3 == 0){
        direct.build(new SimpleIndicatorBuilder(indicator));
        getChildren().add(indicator);
        System.out.println("Сработало");
        counter = 0;
        }
    }
}
