package com.example.task_9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Random;
import java.util.Arrays;

public class HelloController {

    @FXML
    private TextField inputField;
    @FXML
    private TextField textField;
    @FXML
    private RadioButton selectionSortRadioButton;

    @FXML
    private RadioButton bubbleSortRadioButton;

    @FXML
    private Label resultLabel; // Метка для отображения результатов

    private int[] numbers; // Массив чисел, который нужно отсортировать

    public void generateRandomArray() {
        int size = 10; // Размер случайного массива (можете задать по вашему усмотрению)
        numbers = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100); // Генерировать случайное число от 0 до 99
        }

        String arrayAsString = Arrays.toString(numbers);
        resultLabel.setText("Случайный массив сгенерирован");
        inputField.setText(arrayAsString);
    }

    @FXML
    public void selectionSortButtonClicked() {
        if (numbers == null) {
            resultLabel.setText("Ошибка: массив не заполнен");
            return;
        }
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(numbers);
        resultLabel.setText("Массив отсортирован методом выбора");
        String sortedArray = Arrays.toString(numbers); // Преобразовать массив в строку
        textField.setText(sortedArray); // Установить отсортированный массив в TextField2
    }

    @FXML
    public void bubbleSortButtonClicked() {
        if (numbers == null) {
            resultLabel.setText("Ошибка: массив не заполнен");
            return;
        }
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(numbers);
        resultLabel.setText("Массив отсортирован методом пузырька");
        String sortedArray = Arrays.toString(numbers); // Преобразовать массив в строку
        textField.setText(sortedArray); // Установить отсортированный массив в TextField2
    }


    private SortingStrategy getSelectedSortingStrategy() {
        if (selectionSortRadioButton.isSelected()) {
            return new SelectionSort();
        } else if (bubbleSortRadioButton.isSelected()) {
            return new BubbleSort();
        } else {
            // Вернуть стратегию по умолчанию или обработать другие случаи.
            return null;
        }
    }
}