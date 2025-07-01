package cz.filipvarga.booking.service;

import cz.filipvarga.booking.domain.Location;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {
    public WeatherData getWeather(Location location);
}
