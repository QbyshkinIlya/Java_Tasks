package src4.model;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    ArrayList<Question> questionsList = new ArrayList<>();

    public Storage() {
        load("src/main/resources/questions.txt");
    }
    public Storage(String filename) {load(filename);}

    private void load(String filename) {
        String temp;
        Question qtemp;
        FileReader fileReader;

        try {
            fileReader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            return;
        }

        Scanner scanner = new Scanner(fileReader);
        scanner.useDelimiter("\\n");
        while (scanner.hasNextLine()) {
            qtemp = new Question();
            temp = scanner.nextLine();
            qtemp.setQuestion(temp);

            while(!(temp=scanner.nextLine()).equalsIgnoreCase("#bad")){
                qtemp.addTrue(temp);
            }
            while(!(temp=scanner.nextLine()).equalsIgnoreCase("#vopros")){
                qtemp.addFalse(temp);
            }
            questionsList.add(qtemp);
        }
        System.out.println("файл считан" + questionsList.size());
    }

    public ArrayList<Question> getQuestionsList() {
        return questionsList;
    }
}