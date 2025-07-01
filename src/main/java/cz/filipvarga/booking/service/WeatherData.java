package cz.filipvarga.booking.service;

import lombok.Getter;

@Getter
public class WeatherData {
    private double temperature;
    private String description;

    WeatherData(double temperature, String description) {
        this.temperature = temperature;
        this.description = description;
    }
}
