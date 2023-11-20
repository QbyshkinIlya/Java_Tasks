package src4.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// генерирует N вопросов из базы, получает ответ на каждый вопрос и проверяет его правильность, после N ответов выводит статистику.

public class Examinator {
    private Storage storage;
    private List<Question> questions;
    private int questionCount;
    private int answeredCount;
    private int correctCount;
    Random random = new Random();
    public Examinator(){
        storage = new Storage();
        questions = new ArrayList<>();
        questionCount = 3;
        answeredCount = 0;
        correctCount = 0;
    }

    // генерирует N вопросов из базы
    public Question action() {
        List<Question> allQuestions = storage.getQuestionsList();
        if (allQuestions.isEmpty() || questionCount <= 0) {return null;}

        for (int i = 0; i < questionCount; i++) {
            int randomIndex = random.nextInt(allQuestions.size());
            questions.add(allQuestions.get(randomIndex));
        }
        return questions.get(answeredCount);
    }

    // получает ответ на каждый вопрос и проверяет его правильность
    public boolean check(String answer) {
        if (answeredCount < questions.size()) {
            Question currentQuestion = questions.get(answeredCount);
            boolean isCorrect = currentQuestion.getGoodAnswer().contains(answer);
            if (!isCorrect) {
                correctCount++;
            }
            answeredCount++;
            return isCorrect;
        }
        return false;
    }

    // после N ответов выводит статистику
    public String end() {
        return "Statistics:\n" +
                "Question Count: " + questionCount + "\n" +
                "Answered Count: " + answeredCount + "\n" +
                "Correct Count: " + correctCount + "\n";
    }
}
