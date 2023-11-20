package com.example.finalkursovoy;

/**
 * Класс паттерна Singleton
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Приватный конструктор, чтобы предотвратить создание экземпляров извне.
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

