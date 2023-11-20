package com.example.finalkursovoy;


import com.grum.geocalc.EarthCalc;
import com.grum.geocalc.Point;

/**
 * Класс калькулятора для расчета маршрута
 */
public class DistanceCalculator {
    private DistanceCalculator(){

    }
    private static final DistanceCalculator instance = new DistanceCalculator();

    /**
     * Использование singleton-а
     * @return объект класса DistanceCalculator
     */
    public static DistanceCalculator getInstance() {
        return instance;
    }

    /**
     * Метод для реализации метода calculateVincentyDistance
     * @param point1
     * @param point2
     * @return расстояние
     */
    public static double calculateDistanceVincentyCar(Point point1, Point point2){
        return calculateVincentyDistance(point1.latitude, point1.longitude, point2.latitude, point2.longitude);
    }

    /**
     * Метод, реализующий формулу Лося Винсента дял подсчета расстояния между двумя точками по координатам
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @return
     */
    private static double calculateVincentyDistance(double lat1, double lon1, double lat2, double lon2) {

        double a = 6378137.0; // Экваториальный радиус Земли в метрах
        double f = 1 / 298.257223563; // Плоскостной коэффициент
        double b = (1 - f) * a; // Полярный радиус Земли

        double U1 = Math.atan((1 - f) * Math.tan(Math.toRadians(lat1)));
        double U2 = Math.atan((1 - f) * Math.tan(Math.toRadians(lat2)));
        double L = Math.toRadians(lon2 - lon1);
        double sinU1 = Math.sin(U1);
        double cosU1 = Math.cos(U1);
        double sinU2 = Math.sin(U2);
        double cosU2 = Math.cos(U2);

        double lambda = L;
        double lambdaP, sinSigma, cosSigma, sigma, sinAlpha, cos2Alpha, cos2SigmaM, C;

        do {
            double sinLambda = Math.sin(lambda);
            double cosLambda = Math.cos(lambda);
            sinSigma = Math.sqrt((cosU2 * sinLambda) * (cosU2 * sinLambda) +
                    (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda) * (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda));

            if (sinSigma == 0) {
                return 0.0;
            }

            cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
            sigma = Math.atan2(sinSigma, cosSigma);
            sinAlpha = cosU1 * cosU2 * sinLambda / sinSigma;
            cos2Alpha = 1 - sinAlpha * sinAlpha;
            cos2SigmaM = cosSigma - 2 * sinU1 * sinU2 / cos2Alpha;
            C = f / 16 * cos2Alpha * (4 + f * (4 - 3 * cos2Alpha));
            lambdaP = lambda;
            lambda = L + (1 - C) * f * sinAlpha *
                    (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM)));
        } while (Math.abs(lambda - lambdaP) > 1e-12);

        double u2 = cos2Alpha * (a * a - b * b) / (b * b);
        double A = 1 + u2 / 16384 * (4096 + u2 * (-768 + u2 * (320 - 175 * u2)));
        double B = u2 / 1024 * (256 + u2 * (-128 + u2 * (74 - 47 * u2)));
        double deltaSigma = B * sinSigma * (cos2SigmaM + B / 4 * (cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM) -
                B / 6 * cos2SigmaM * (-3 + 4 * sinSigma * sinSigma) * (-3 + 4 * cos2SigmaM * cos2SigmaM)));

        return b * A * (sigma - deltaSigma); // Расстояние в метрах
    }
}

