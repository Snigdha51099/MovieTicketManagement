package com.cg.movie.web;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.dto.ErrorMessage;
import com.cg.movie.exceptions.AddMovieException;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.exceptions.MovieSearchException;
import com.cg.movie.exceptions.ValidateMovieException;

@RestControllerAdvice 
public class SearchMovieAdvice {
	
	@ExceptionHandler(MovieSearchException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleSearchException(MovieSearchException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
	}
	@ExceptionHandler(MovieNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ErrorMessage handleDeleteException(MovieNotFoundException ex)
	{
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
	}
	@ExceptionHandler(ValidateMovieException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleException(ValidateMovieException ex)
	{ 
		List<String> errors=ex.getErrorList().stream().map(err->err.getDefaultMessage()).collect(Collectors.toList());
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), errors, LocalDateTime.now().toString());
	}
	

	@ExceptionHandler(AddMovieException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ErrorMessage handleDeleteException(AddMovieException ex)
	{
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
	}
}
