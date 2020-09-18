package com.cg.movie.service;

import java.util.List;

import com.cg.dto.MovieDto;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.Show;
import com.cg.movie.exceptions.AddMovieException;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.exceptions.MovieSearchException;

public interface MovieService {
	public List<Movie> searchMovies(String movie)throws MovieSearchException;
	public Movie addMovie(MovieDto movieDto) throws AddMovieException;
	public String deleteMovie(int movieid) throws MovieNotFoundException;
	public List<Show> getShows(String location) throws MovieNotFoundException;
	//public List<String> getLocations();
	
}
