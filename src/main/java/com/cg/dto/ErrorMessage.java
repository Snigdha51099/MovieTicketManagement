package com.cg.dto;

import java.util.List;

public class ErrorMessage {
	private String status;
	private String message;
	private String timestamp;
	private List<String> messages;

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public ErrorMessage(String status, List<String> messages, String timestamp) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.messages = messages;
	}

	public ErrorMessage(String status, String message, String timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
