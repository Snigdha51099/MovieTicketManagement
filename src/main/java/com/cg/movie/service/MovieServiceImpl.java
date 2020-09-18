package com.cg.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dto.DeleteMovieSuccessMessage;
import com.cg.dto.MovieDto;
import com.cg.movie.dao.IMovieDao;
import com.cg.movie.dao.ShowDao;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.Show;
import com.cg.movie.exceptions.AddMovieException;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.exceptions.MovieSearchException;
import com.cg.movie.util.MovieConstants;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private IMovieDao movieDao;
	@Autowired
	private ShowDao showdao;

	@Override
	
	public List<Movie> searchMovies(String movie) throws MovieSearchException {
		List<Movie> movieList = movieDao.searchMovies(movie);
		if (movieList.isEmpty())
			throw new MovieSearchException(MovieConstants.MOVIE_NOT_AVAILABLE);
		movieList = movieList.stream().filter(m->m.getActive()==MovieConstants.ACTIVE_MOVIE).collect(Collectors.toList());
		movieList.sort((m1,m2)->m2.getReleaseDt().compareTo(m1.getReleaseDt()));
		return movieList;
	}
	@Override
	
	public 	Movie addMovie(MovieDto movieDto) throws AddMovieException {
		Optional<Movie> opt=movieDao.findById(movieDto.getMovieId());
		if(opt.isPresent())
			throw new AddMovieException(MovieConstants.MOVIE_ALREADY_EXIST);
		Movie movie=new Movie();
		movie.setMovieId(movieDto.getMovieId());
		movie.setMovieName(movieDto.getMovieName());
		movie.setLanguage(movieDto.getLanguage());
		movie.setDirector(movieDto.getDirector());
		movie.setGenre(movieDto.getGenre());
		movie.setActive(movieDto.getActive());
		movie.setReleaseDt(movieDto.getReleaseDt());
		return movieDao.save(movie);
		
	}
	
	@Override
	public String deleteMovie(int movieId) throws MovieNotFoundException
	{
		Optional<Movie> opt=movieDao.findById(movieId);
		if (!opt.isPresent())
			throw new MovieNotFoundException(MovieConstants.MOVIE_ID_NOT_FOUND);
		Movie movie=opt.get();
		movieDao.deleteById(movieId);
		return MovieConstants.DELETE_MOVIE;
	}
	@Override
	public List<Show> getShows(String location) throws MovieNotFoundException {
		List<Show> list=showdao.getShows(location);
		if(list.isEmpty())
			throw new MovieNotFoundException(MovieConstants.MOVIE_ID_NOT_FOUND);
		list.sort((s1,s2)->s1.getMovie().getMovieName().compareTo(s2.getMovie().getMovieName()));
		
		return list;
	}

	
	

}
