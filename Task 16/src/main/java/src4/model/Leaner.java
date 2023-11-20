package src4.model;

import java.util.List;
import java.util.Random;

public class Leaner {
    private Storage storage;
    private Question question;
    private int currentQuestionIndex;
    int correctCount = 0;
    Random random = new Random();

    public Leaner(){
        storage = new Storage();
        question = new Question();
        currentQuestionIndex = -1;
    }

    // формирует вопрос из списка вопросов
    public Question action() {
        List<Question> questionsList = storage.getQuestionsList();
        if (!questionsList.isEmpty()) {
            currentQuestionIndex = random.nextInt(questionsList.size());
            question = questionsList.get(currentQuestionIndex);
            return question;
        }
        return null;
    }

    //проверяет ответ answer на вопрос
    public boolean check(String answer) {
        if (question != null) {
            boolean isCorrect = question.getGoodAnswer().contains(answer);
            if (isCorrect) {
                correctCount++;
                return true;
            }
        }
        return false;
    }

    // выводит статистику по результатам теста
    public String end() {
        return "Test results:\n" +
                "Correct answers: " + correctCount;
    }
}
