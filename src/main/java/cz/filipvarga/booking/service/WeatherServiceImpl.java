package cz.filipvarga.booking.service;

import cz.filipvarga.booking.domain.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

public class WeatherServiceImpl implements WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public WeatherData getWeather(Location location) {
        String url =    "https://api.openweathermap.org/data/2.5/weather?" +
                        "lat=" + location.getLatitude() + "&lon=" + location.getLongitude() +
                        "&appid=" + apiKey + "&units=metric";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Parse JSON response
        JSONObject json = new JSONObject(response.getBody());

        double temperature = json.getJSONObject("main").getDouble("temp");
        String icon = json.getJSONArray("weather").getJSONObject(0).getString("icon");

        return new WeatherData(temperature, icon);
    }
}
