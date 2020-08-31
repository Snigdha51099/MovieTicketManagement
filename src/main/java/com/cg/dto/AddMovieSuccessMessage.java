package com.cg.dto;

public class AddMovieSuccessMessage {
	private String message;

	public AddMovieSuccessMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
