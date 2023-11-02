package com.example.task_9;

public class SelectionSort implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        int i, j, first, temp;
        for (i = numbers.length - 1; i > 0; i--) {
            first = 0;
            for (j = 1; j <= i; j++) {
                if (!compare(numbers[j], numbers[first]))
                    first = j;
            }
            temp = numbers[first];
            numbers[first] = numbers[i];
            numbers[i] = temp;
        }
    }

    private boolean compare(int a, int b) {
        return a < b;
    }
}
