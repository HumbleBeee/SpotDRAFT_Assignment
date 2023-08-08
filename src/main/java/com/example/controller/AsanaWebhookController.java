package com.example.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AsanaWebhookPayload;
import com.example.entity.AsanaTask;
import com.example.repository.AsanaTaskRepository;
import com.example.service.AirtableService;

@RestController
@RequestMapping("/webhook")
public class AsanaWebhookController {

	@Autowired
	private AsanaTaskRepository taskRepository;
	
	@Autowired
	private AirtableService airtableService;
	
	@PostMapping("/asana")
	public  ResponseEntity<String> handleAsanaWebhook(@RequestBody AsanaWebhookPayload payload){
		String taskId = payload.getTask_id();
        String name = payload.getName();
        String assignee = payload.getAssignee();
        LocalDate dueDate = payload.getDue_on();
        //payload.getDue_on();
        String description = payload.getDescription();
        AsanaTask task = new AsanaTask(taskId, name, assignee, dueDate, description);
        taskRepository.save(task);
        
        airtableService.createAirtableTask(task);

        return ResponseEntity.ok("Task processed successfully");
	}
	
    
}
