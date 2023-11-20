package com.example.finalkursovoy.openRouteService;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Класс для геокодирования с помощью сервиса openRouteService
 */
public class OpenRouteServiceGeocodingUtil  {
    private static final String BASE_URL = "https://api.openrouteservice.org/geocode/search";
    private static final String API_KEY = "5b3ce3597851110001cf624873435e539d3542988cb4c30a2563543c";

    /**
     * Метод для получения координат после ввода пользователем городов
     * @param cityName
     * @param callback
     */
    public void getCoordinates(String cityName, OpenRouteServiceGeocodingCallback callback) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "?api_key=" + API_KEY + "&text=" + cityName);

        try {
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String jsonResponse = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                        .lines().collect(Collectors.joining("\n"));

                // Используйте Gson для разбора JSON
                Gson gson = new Gson();
                OpenRouteServiceGeocodingResponse geocodingResponse = gson.fromJson(jsonResponse, OpenRouteServiceGeocodingResponse.class);

                if (geocodingResponse.features != null && geocodingResponse.features.length > 0) {
                    double lat = geocodingResponse.features[0].geometry.coordinates[1];
                    double lon = geocodingResponse.features[0].geometry.coordinates[0];

                    callback.onSuccess(lat, lon);
                } else {
                    callback.onError("Ошибка получения координат из JSON-файла");
                }
            } else {
                callback.onError("Ошибка получения координат. Status code: " + response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            callback.onError("Ошибка соединения: " + e.getMessage());
        }
    }

}
