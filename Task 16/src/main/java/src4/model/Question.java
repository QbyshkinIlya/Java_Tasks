package src4.model;

import java.util.ArrayList;

public class Question {
    String question;
    ArrayList<String> answerGood;
    ArrayList<String> answerBad;

    public Question() {
        answerGood = new ArrayList<>();
        answerBad = new ArrayList<>();
    }

    public void setQuestion(String temp) {
        question = temp;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getGoodAnswer() {
        return answerGood;
    }

    public ArrayList<String> getBadAnswer() {
        return answerBad;
    }

    public int addTrue(String value) {
        answerGood.add(value);
        return answerGood.size();
    }

    public int addFalse(String value) {
        answerBad.add(value);
        return answerBad.size();
    }
}