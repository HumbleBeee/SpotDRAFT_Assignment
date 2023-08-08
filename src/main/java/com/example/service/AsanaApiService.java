package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.entity.AsanaTask;

public class AsanaApiService {

	private final String ASANA_API_BASE_URL = "https://app.asana.com/api/1.0";

    @Value("${asana.personal.access.token}")
    private String ASANA_PERSONAL_ACCESS_TOKEN;

    public String fetchAsanaTasks() {
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + ASANA_PERSONAL_ACCESS_TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Replace "/your/api/endpoint" with the actual Asana API endpoint you want to call
        ResponseEntity<String> response = restTemplate.exchange(
            ASANA_API_BASE_URL + "/tasks",
            HttpMethod.GET,
            entity,
            String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return "Failed to fetch tasks from Asana. Response: " + response.getBody();
        }
    }
}
