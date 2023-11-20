package com.example.finalkursovoy.openRouteService;

/**
 * Интерфейс для использования сервиса геокодирования openRouteService
 */
public interface OpenRouteServiceGeocodingCallback {
    /**
     * Метод для геокодирования
     * @param latitude
     * @param longitude
     */
    void onSuccess(double latitude, double longitude);

    /**
     * Метод вывода в случае ошибки
     * @param errorMessage
     */
    void onError(String errorMessage);
}
