package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Qweston {
    private StringProperty question;
    private ArrayList<StringProperty> answerGood;//изменение имен добавлены модификаторы для инкапсуляции
    private ArrayList<StringProperty> badAnswer;//изменение имен


    public Qweston(String question) {
        this.question = new SimpleStringProperty(question);
        this.answerGood = new ArrayList<>();
        this.badAnswer = new ArrayList<>();
    }

    public int addTrue(String answer) {
        answerGood.add(new SimpleStringProperty(answer));
        return answerGood.size();
    }

    public int addFalse(String answer) {
        badAnswer.add(new SimpleStringProperty(answer));
        return badAnswer.size();
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }

    public ArrayList<StringProperty> getAnswerGood() {
        return answerGood;
    }

    public void setAnswerGood(ArrayList<StringProperty> answerGood) {
        this.answerGood = answerGood;
    }

    public ArrayList<StringProperty> getBadAnswer() {
        return badAnswer;
    }

    public void setBadAnswer(ArrayList<StringProperty> badAnswer) {
        this.badAnswer = badAnswer;
    }

    public String getQuestion() {
        return question.get();
    }

    public StringProperty questionProperty() {
        return question;
    }
}