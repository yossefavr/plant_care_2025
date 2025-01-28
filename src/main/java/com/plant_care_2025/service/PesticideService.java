package com.plant_care_2025.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plant_care_2025.model.Pesticide;

@Service
public class PesticideService {

    private final RestTemplate restTemplate;

    public PesticideService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Pesticide> fetchPesticides() {
        String apiUrl = "https://data.gov.il/api/3/action/datastore_search?resource_id=3ee1cd66-6176-4c1f-8d38-8f36a1461426&limit=5";

        try {
            // Fetch the API response
            String response = restTemplate.getForObject(apiUrl, String.class);

            // Log the raw JSON response
            System.out.println("API Response: " + response);

            // Parse JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode records = rootNode.path("result").path("records");

            // Map JSON to Pesticide objects
            List<Pesticide> pesticides = new ArrayList<>();
            for (JsonNode record : records) {
                Pesticide pesticide = new Pesticide();
                pesticide.setId(record.path("_id").asLong());
                pesticide.setName(record.path("שם מסחרי").asText()); // Adjust field names based on response
                pesticide.setType(record.path("סוג החומר").asText()); // Adjust field names based on response
                pesticide.setDescription(record.path("הערות").asText()); // Adjust field names based on response
                pesticides.add(pesticide);
            }
            return pesticides;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Return an empty list on error
        }
    }
}
