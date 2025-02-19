package com.plant_care_2025.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final String BASE_URL = "https://api.openweathermap.org/data/3.0/onecall";

    // This method fetches the raw JSON and also parses it for specific data
    public String getWeatherByCoordinates(double lat, double lon) {
        String url = String.format("%s?lat=%f&lon=%f&appid=%s", BASE_URL, lat, lon, apiKey);
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Fetch the raw JSON response
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            
            if (response.getStatusCode().is2xxSuccessful()) {
                // Store the raw JSON for other uses
                String rawWeatherData = response.getBody();
                
                // Parse the JSON for display
                String userFriendlyWeatherData = parseWeatherData(rawWeatherData);
                
                // You can save the rawWeatherData elsewhere or return it
                return userFriendlyWeatherData;  // Return the parsed weather data for the view
            } else {
                return "Error: Unable to fetch weather data.";
            }
        } catch (Exception e) {
            return "An error occurred while fetching the weather data.";
        }
    }

    // Parse the JSON and return a user-friendly summary
    private String parseWeatherData(String weatherData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(weatherData);
            JsonNode currentWeather = rootNode.path("current");

            // Extract temperature, weather condition, humidity
            double temperature = currentWeather.path("temp").asDouble();
            String weatherCondition = currentWeather.path("weather").get(0).path("description").asText();
            int humidity = currentWeather.path("humidity").asInt();

            // Return a user-friendly summary for display
            return String.format("Temperature: %.2f°C\nCondition: %s\nHumidity: %d%%",
                       temperature - 273.15, weatherCondition, humidity);
        } catch (Exception e) {
            return "Error parsing weather data.";
        }
    }
}
