package model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListCell;

public class ShapeCell extends ListCell<Shapes> {// класс Product

    @Override
    public void updateItem(Shapes item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            Canvas cnv=new Canvas();
            cnv.setHeight(110.0);// задание размера элемента отображения
            cnv.setWidth(110.0);
            GraphicsContext gc=cnv.getGraphicsContext2D();
            Shapes item1=(Shapes)item.clone();//текущая фигура из списка ObservableList
            item1.Draw(gc,1.0, 1.0, 0); // ее отрисовка на канве
            setGraphic(cnv); //установка канвы вместо cell
        }

    }

}