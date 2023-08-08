package com.example.airtable;

import com.example.entity.AsanaTask;

public class AirtableRowRequestBody {

	private Fields fields;

    public AirtableRowRequestBody(AsanaTask task) {
        this.fields = new Fields(task);
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public static class Fields {
        private String task_id;
        private String name;
        private String assignee;
        private String due_date;
        private String description;

        public Fields(AsanaTask task) {
            this.task_id = task.getTaskId();
            this.name = task.getName();
            this.assignee = task.getAssignee();
            this.due_date = task.getDuedate().toString();
            this.description = task.getDescription();
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

		public String getDue_date() {
			return due_date;
		}

		public void setDue_date(String due_date) {
			this.due_date = due_date;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
    }   
}
