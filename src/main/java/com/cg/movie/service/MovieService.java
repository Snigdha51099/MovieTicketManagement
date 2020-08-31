package com.cg.movie.service;

import java.util.List;

import com.cg.dto.MovieDto;
import com.cg.movie.entity.Movie;
import com.cg.movie.exceptions.AddMovieException;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.exceptions.MovieSearchException;

public interface MovieService {
	public List<Movie> searchMovies(String movie)throws MovieSearchException;

	//public Movie addMovie(MovieDto moviedto) throws AddMovieException;
	

	//public boolean deleteMovie(int movieid) throws MovieNotFoundException;
	
}
