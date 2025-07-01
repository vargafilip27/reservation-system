package cz.filipvarga.booking.service;

import lombok.Getter;

@Getter
public class WeatherData {
    private double temperature;
    private String icon;

    WeatherData(double temperature, String icon) {
        this.temperature = temperature;
        this.icon = icon;
    }
}
