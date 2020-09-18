package com.cg.movie.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.AddMovieSuccessMessage;
import com.cg.dto.DeleteMovieSuccessMessage;
import com.cg.dto.MovieDto;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.Show;
import com.cg.movie.exceptions.AddMovieException;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.exceptions.MovieSearchException;
import com.cg.movie.exceptions.ValidateMovieException;
import com.cg.movie.service.MovieService;
import com.cg.movie.util.MovieConstants;

@RestController 
@CrossOrigin(origins= {"http://localhost:4200"}) 
public class SearchMovieMicroservice {
	
	@Autowired
	private MovieService movieService;

	@GetMapping(MovieConstants.SEARCH_MOVIE_URL)
	public List<Movie> searchMovies(@PathVariable("mname") String movie) throws MovieSearchException{
		List<Movie> mlist=movieService.searchMovies(movie);
		return mlist;
	}
	@PostMapping(MovieConstants.ADD_MOVIE_URL)
	public AddMovieSuccessMessage addMovie (@Valid@RequestBody MovieDto moviedto, BindingResult br) throws AddMovieException, ValidateMovieException
	{
		if(br.hasErrors()) {
			throw new ValidateMovieException(br.getFieldErrors());
		}
		Movie movie=movieService.addMovie(moviedto);
		return new AddMovieSuccessMessage(MovieConstants.ADD_MOVIE);
	}

	@DeleteMapping(MovieConstants.DELETE_MOVIE_URL)
	public DeleteMovieSuccessMessage deleteMovie(@PathVariable("movieid") int movieId) throws MovieNotFoundException
	{
		movieService.deleteMovie(movieId);
		return new DeleteMovieSuccessMessage(MovieConstants.DELETE_MOVIE);
	}
	@GetMapping(MovieConstants.GET_SHOWS_URL)
	public List<Show> getShows(@PathVariable("loc") String location) throws MovieNotFoundException
	{
		List<Show> list=movieService.getShows(location);
		return list;
	}
	
}
