package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public Map<String, Double> averageTemperature() {
        Map<String, Double> average = new HashMap<>();

        for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()) {

            average.put(entry.getKey(), entry.getValue());

        }
        return average;
    }

    public Map<String, Double> medianTemperature() {
        Map<String, Double> median = new HashMap<>();

        for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()) {

            median.put(entry.getKey(), entry.getValue());
        }
        return median;
    }
}
