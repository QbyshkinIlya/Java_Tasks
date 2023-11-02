package com.example.task17sync.model;

import com.example.task17sync.HelloController;

import java.util.ArrayList;
import java.util.List;


public class MyRunnable extends Thread{
    private long start;
    private long end;

    Long max;
    public MyRunnable(long start, long end){
        this.start = start;
        this.end = end;
    }
    public void setMax(Long max) {
        this.max = max;
    }

    public void run() {

        for (long i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
