package com.example.dto;

import java.time.LocalDate;

public class AsanaWebhookPayload {

	private String task_id;
    private String name;
    private String assignee;
    private LocalDate due_on;
    private String description;
    
    public AsanaWebhookPayload() {
		// TODO Auto-generated constructor stub
	}

	public AsanaWebhookPayload(String task_id, String name, String assignee, LocalDate due_on, String description) {
		super();
		this.task_id = task_id;
		this.name = name;
		this.assignee = assignee;
		this.due_on = due_on;
		this.description = description;
	}

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public LocalDate getDue_on() {
		return due_on;
	}

	public void setDue_on(LocalDate due_on) {
		this.due_on = due_on;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
