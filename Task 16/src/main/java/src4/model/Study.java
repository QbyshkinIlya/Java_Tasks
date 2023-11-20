package src4.model;

import java.util.List;
import java.util.Random;

// задает вопрос, получает ответ, выводит правильный.
public class Study {
    private Storage storage;
    private Question question;
    private int currentQuestionIndex;
    Random random = new Random();

    public Study(){
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

    // получает ответ
    public boolean check(String answer) {
        return question.getGoodAnswer().contains(answer);
    }

    // выводит правильный
    public String end() {
        return "Correct answer: " + question.getGoodAnswer();
    }
}
