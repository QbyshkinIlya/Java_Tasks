package com.example.task_10;
import java.util.Arrays;
import java.util.ArrayList;

public class OrdArrayAdapter<E extends Comparable<E>> implements Adapter<E> {
    private OrdArray<E> ordArray;

    public OrdArrayAdapter() {
        ordArray = new OrdArray<>(1000); // Создание объекта OrdArray
    }

    @Override
    public String toString(ArrayList<E> list) {
        StringBuilder sb = new StringBuilder();
        for (E element : list) {
            sb.append(element.toString()).append(" ");
        }
        return sb.toString();
    }

    @Override
    public void insert(E element) {
        ordArray.insert(element);
    }

    @Override
    public void remove(E element) {
        ordArray.delete(element);
    }

    @Override
    public E find(E element) {
        int index = ordArray.find(element); // Получить индекс элемента
        if (index != -1) {
            // Вернуть элемент из массива, используя индекс
            return ordArray.getElementByIndex(index);
        } else {
            return null; // Вернуть null, если элемент не найден
        }
    }

    public ArrayList<String> display() {
        String[] subStr;
        String delimiter = " ";
        subStr = ordArray.display().split(delimiter);
        return new ArrayList<>(Arrays.asList(subStr));
    }
}
