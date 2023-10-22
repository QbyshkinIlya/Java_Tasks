package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Signal extends ImageView implements IObserver {
    public ImageCollection imgs = new ImageCollection();

    public Iterator iter_main = imgs.getIterator();
    public int counter;

    public Signal ()  {
        setFitHeight(343.0);
        setFitWidth(570.0);
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
