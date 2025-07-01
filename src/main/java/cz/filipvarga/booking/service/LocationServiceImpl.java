package cz.filipvarga.booking.service;

import cz.filipvarga.booking.domain.Location;
import cz.filipvarga.booking.repository.LocationRepository;

import java.util.List;

public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final WeatherService weatherService;

    public LocationServiceImpl( LocationRepository locationRepository,
                                WeatherService weatherService           ) {
        this.locationRepository = locationRepository;
        this.weatherService = weatherService;
    }

    @Override
    public List<Location> getAllLocations() {
        List<Location> locations = locationRepository.findAll();

        for (Location location : locations) {
            WeatherData weatherData = weatherService.getWeather(location);

            location.setWeatherIcon(weatherData.getIcon());
            location.setTemperature(weatherData.getTemperature());
        }

        return locations;
    }
}
