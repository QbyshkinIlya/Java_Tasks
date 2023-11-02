package com.example.task_9;

public class CurrentContext {
    private SortingStrategy strategy;

    public void setSortingMethod(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public SortingStrategy getStrategy() {
        return strategy;
    }

    public void sortNumbers(int[] numbers) {
        strategy.sort(numbers);
    }
}
