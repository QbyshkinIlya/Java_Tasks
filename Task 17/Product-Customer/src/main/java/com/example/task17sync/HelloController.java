package com.example.task17sync;

import com.example.task17sync.model.MyRunnable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    public TextField maxNumber;
    @FXML
    public TextField threadCount;
    @FXML
    public Label res;

    MyRunnable myRunnable;

    public void running(){
        long max = Long.valueOf(maxNumber.getText()); // Получите максимальное значение из текстового поля
        int threadCount1 = Integer.valueOf(threadCount.getText()); // Получите количество потоков из текстового поля

        long time = System.currentTimeMillis();
        long blockSize = max / threadCount1;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount1; i++) {
            long start = i * blockSize + 1;
            long end = (i == threadCount1 - 1) ? max : (i + 1) * blockSize;
            MyRunnable nr = new MyRunnable(start, end);

            // Создание объектов-потоков
            Thread thread = new Thread(nr);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long executionTime = System.currentTimeMillis() - time;
        System.out.println("Total execution time: " + executionTime + " milliseconds");
    }


}