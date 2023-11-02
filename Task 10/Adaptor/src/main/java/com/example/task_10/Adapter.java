package com.example.task_10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public interface Adapter<E> {
    String toString(ArrayList<E> list);
    void insert(E element);
    void remove(E element);
    E find(E element);

    ArrayList<String> display();
}
