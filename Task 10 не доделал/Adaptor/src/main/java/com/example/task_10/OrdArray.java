package com.example.task_10;
public class OrdArray<E extends Comparable<E>> {
    private E[] a;
    private int nElems;

    public OrdArray(int maxSize) {
        a = (E[]) new Comparable[maxSize]; // Создание массива заданного размера
        nElems = 0; // Изначально массив пуст
    }

    public void insert(E value) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (a[i].equals(value)) {
                // Элемент уже существует, не вставляем дубликат
                return;
            } else if (a[i].compareTo(value) > 0) {
                break;
            }
        }

        for (int j = nElems; j > i; j--) {
            a[j] = a[j - 1];
        }

        a[i] = value;
        nElems++;
    }

    public boolean delete(E value) {
        int i = find(value);
        if (i == -1) {
            // Элемент не найден, нечего удалять
            return false;
        }

        for (int j = i; j < nElems - 1; j++) {
            a[j] = a[j + 1];
        }
        nElems--;

        return true;
    }

    public int find(E value) {
        for (int i = 0; i < nElems; i++) {
            if (a[i].equals(value)) {
                return i;
            }
        }
        return -1; // Элемент не найден
    }

    public String display() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nElems; i++) {
            result.append(a[i]);
            if (i < nElems - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public E getElementByIndex(int index) {
        if (index >= 0 && index < nElems) {
            return a[index];
        }
        return null; // Если индекс за пределами массива, вернуть null или другое значение по умолчанию
    }
}

