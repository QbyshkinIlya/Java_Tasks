package com.example.finalkursovoy.openRouteService;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *Класс для работы с JSON файлом, его разбора от сервиса геокодирования openRouteService
 */
public class OpenRouteServiceGeocodingResponse {
    /**
     * Массив объектов класса Feature
     */
    @SerializedName("features")
    @Expose
    public Feature[] features;

    /**
     * Класс для предоставления полученного обьекта из JSON
     */
    public static class Feature {
        /**
         * Объявляет поле geometry для хранения объекта из JSON
         */
        @SerializedName("geometry")
        @Expose
        public Geometry geometry;
    }

    /**
     * Класс пресдавтляет собой координаты из JSON
     */
    public static class Geometry {
        /**
         * Хранение координат объекта из JSON
         */
        @SerializedName("coordinates")
        @Expose
        public double[] coordinates;
    }
}
