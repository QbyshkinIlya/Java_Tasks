package com.aplicationfx.demo.model;

public class Calculator {
    private Double number;
    private Double percent;

    public Double getNumber() {
        return number;
    }
    public void setNumber(Double number) {
        this.number = number;
    }
    public Double getPercent() {
        return percent;
    }
    public void setPercent(Double percent) {
        this.percent = percent;
    }
    public Double calc() { return number * percent / 100; }
}
