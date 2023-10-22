package model.SlaidWoy;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.IObserver;

public class SlaidWoy extends ImageView implements IObserver {
    public ImageCollection imgs = new ImageCollection();
    @FXML
    public Iterator iter_main = imgs.getIterator();
    public  int counter = 0;

    public SlaidWoy() {
        setFitHeight(343.0);
        setFitWidth(600.0);
    }

    @Override
    public void update() {
        counter++;
        if(counter % 5 == 0){
            if (iter_main.hasNext()) {
                Image name = (Image) iter_main.next();
                setImage(name);
            }
            counter = 0;
        }
    }
}
