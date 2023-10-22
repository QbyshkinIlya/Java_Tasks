package model;

import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;
import java.util.ArrayList;

public class Viewer extends Colleague {

    private static final int NUMBER = 10;//константа изменена на private static final для указания что это константа класса

    public Viewer(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notifyColleague(ArrayList<Qweston> test) {
        StringBuilder str = new StringBuilder();//используется для форматирования строки которая содержит инфо о вопросах
        for (int i = 0; i < test.size(); i++) {
            str.append((i + 1)).append(" ").append(test.get(i).getQuestion()).append("\n\r");
            for (StringProperty answer : test.get(i).getAnswerGood()) {
                str.append(answer).append("\n");
            }
            str.append("НЕВЕРНО").append("\n\r");
            for (StringProperty answer : test.get(i).getBadAnswer()) {
                str.append(answer).append("\r\n");
            }
        }
        TextArea textArea = new TextArea(str.toString());
        textArea.setWrapText(true);
        mediator.setView(textArea);
    }

    public void receive(ArrayList<Qweston> message) {//убрано присвоение пустого ArrayList так как список уже передается в метод
        ArrayList<Qweston> currenttest = new ArrayList<>(message);
        ArrayList<Qweston> test = new ArrayList<>(message);
        for (int i = 0; i < NUMBER && i < test.size(); i++) {
            int index = (int) (Math.random() * test.size());
            if (index == test.size()) {
                index--;
            }
            currenttest.add(test.get(index));
            test.remove(index);
        }
        super.receive(currenttest);
    }
}