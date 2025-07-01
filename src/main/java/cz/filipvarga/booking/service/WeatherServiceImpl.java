package cz.filipvarga.booking.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

public class WeatherServiceImpl implements WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherData getWeather(double latitude, double longitude) {
        String url =    "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude +
                        "&appid=" + apiKey + "&units=metric";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Simplified parsing (can be replaced with ObjectMapper)
        JSONObject json = new JSONObject(response.getBody());

        double temperature = json.getJSONObject("main").getDouble("temp");
        String description = json.getJSONArray("weather").getJSONObject(0).getString("description");

        return new WeatherData(temperature, description);
    }

}
