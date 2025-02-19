package com.plant_care_2025.controller;

import com.plant_care_2025.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeatherByCoordinates(@RequestParam(value = "lat", required = false) Double lat,
                                           @RequestParam(value = "lon", required = false) Double lon, Model model) {
        if (lat == null || lon == null) {
            model.addAttribute("error", "Please enter both latitude and longitude.");
            return "weather"; // Return the original form with an error message
        }

        // If lat and lon are provided, fetch weather data
        String weatherData = weatherService.getWeatherByCoordinates(lat, lon);
        model.addAttribute("weather", weatherData);
        model.addAttribute("lat", lat);
        model.addAttribute("lon", lon);
        return "weather"; // Return the view with weather data
    }
}
