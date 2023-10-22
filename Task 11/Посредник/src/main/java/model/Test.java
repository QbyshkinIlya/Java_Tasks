package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    private ArrayList<Qweston> test = new ArrayList<>(); //добавлен модификатор доступа private для инкапсуляции

    public Test() {
        load("src/main/resources/com/example/task11/test.txt");
    }

    public Test(String filename) {
        load(filename);
    }

    public ArrayList<Qweston> createTest(int numberQwest) {// изменено на numberQwest
        ArrayList<Qweston> currentTest = new ArrayList<>();
        ArrayList<Qweston> testCopy = new ArrayList<>(test);//добавлено создание копии списка
        for (int i = 0; i < numberQwest; i++) {
            int index = (int) (Math.random() * testCopy.size());
            if (index == testCopy.size()) {
                index--;
            }
            currentTest.add(testCopy.get(index));
            testCopy.remove(index);
        }
        return currentTest;
    }

    public ArrayList<Qweston> getTest() {
        return test;
    }

    public void setTest(ArrayList<Qweston> test) {
        this.test = test;
    }

    private void load(String filename) {
        FileReader fin;
        try {
            fin = new FileReader(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не обнаружен");
            return;
        }

        Scanner scanner = new Scanner(fin);
        scanner.useDelimiter("\\n");

        while (scanner.hasNextLine()) {
            Qweston qweston = new Qweston("");
            String temp = scanner.nextLine();
            qweston.setQuestion(temp);

            while (!(temp = scanner.nextLine()).equalsIgnoreCase("#bad")) {
                qweston.addTrue(temp);
            }

            while (!(temp = scanner.nextLine()).equalsIgnoreCase("#vopros")) {
                qweston.addFalse(temp);
            }

            test.add(qweston);
        }
        System.out.println("Файл обнаружен!");
    }
}