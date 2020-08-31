package com.cg.movie.exceptions;

public class AddMovieException extends RuntimeException{
	public AddMovieException()
	{
		super();
	}
	public AddMovieException(String msg) {
		super(msg);
	}

}
