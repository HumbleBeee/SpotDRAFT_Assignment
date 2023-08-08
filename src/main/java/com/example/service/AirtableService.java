package com.example.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.airtable.AirtableRowRequestBody;
import com.example.entity.AsanaTask;

public class AirtableService {

	private final String AIRTABLE_API_KEY = "patNRiSaiGk9G0bFX.a435a611cf0a4d05b6687afccedd0d6864fa97f39bd87a4e609a446da82b7aad";
    private final String AIRTABLE_BASE_ID = "appkp3FpRS9eaDVlo";
    private final String AIRTABLE_TABLE_NAME = "Asana%20Tasks"; // URL-encoded table name

    private final String AIRTABLE_API_URL = "https://api.airtable.com/v0/" + AIRTABLE_BASE_ID + "/" + AIRTABLE_TABLE_NAME;

    public void createAirtableTask(AsanaTask task) {
        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + AIRTABLE_API_KEY);
        
     // Prepare request body
        AirtableRowRequestBody requestBody = new AirtableRowRequestBody(task);

        // Create HTTP entity
        HttpEntity<AirtableRowRequestBody> entity = new HttpEntity<>(requestBody, headers);

        // Make POST request to Airtable API
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(AIRTABLE_API_URL, entity, String.class);
        
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Task successfully added to Airtable.");
        } else {
            System.err.println("Failed to add task to Airtable. Response: " + response.getBody());
        }
    }

}
