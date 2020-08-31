package com.cg.movie.exceptions;

public class MovieNotFoundException extends RuntimeException{
	public MovieNotFoundException()
	{
		super();
	}
	public MovieNotFoundException(String msg) {
		super(msg);
	}

}
