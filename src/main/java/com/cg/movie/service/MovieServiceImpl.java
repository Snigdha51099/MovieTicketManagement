package com.cg.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dto.MovieDto;
import com.cg.movie.dao.IMovieDao;
import com.cg.movie.entity.Movie;
import com.cg.movie.exceptions.AddMovieException;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.exceptions.MovieSearchException;
import com.cg.movie.util.MovieConstants;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private IMovieDao movieDao;

	@Override
	
	public List<Movie> searchMovies(String movie) throws MovieSearchException {
		List<Movie> movieList = movieDao.searchMovies(movie);
		if (movieList.isEmpty())
			throw new MovieSearchException(MovieConstants.MOVIE_NOT_AVAILABLE);
		movieList = movieList.stream().filter(m->m.getActive()==MovieConstants.ACTIVE_MOVIE).collect(Collectors.toList());
		movieList.sort((m1,m2)->m2.getReleaseDt().compareTo(m1.getReleaseDt()));
		return movieList;
	}
//	@Override
//	
//	public 	Movie addMovie(MovieDto moviedto) throws AddMovieException {
//		Optional<Movie> opt=movieDao.findById(moviedto.getMovieId());
//		if(opt.isPresent())
//			throw new AddMovieException(MovieConstants.MOVIE_ALREADY_EXIST);
//		Movie movie=new Movie();
//		movie.setMovieId(movie.getMovieId());
//		movie.setMovieName(movie.getMovieName());
//		movie.setLanguage(movie.getLanguage());
//		movie.setDirector(movie.getDirector());
//		movie.setGenre(movie.getGenre());
//		movie.setActive(movie.getActive());
//		movie.setReleaseDt(movie.getReleaseDt());
//		//movieDao.save(movie);
//		return movieDao.save(movie);
//		//return MovieConstants.ADD_MOVIE;
//	}
	/*@Override
	public Movie viewMovie(int movieid) throws MovieNotFoundException{
		Optional<Movie> opt=movieDao.findById(movieid);
		if (opt.isPresent())
			return opt.get();
		throw new MovieNotFoundException("No such movie ID exist");
		
	}*/
//	@Override
//	public boolean deleteMovie(int movieid) throws MovieNotFoundException
//	{
//		Optional<Movie> opt=movieDao.findById(movieid);
//		if (!opt.isPresent())
//			throw new MovieNotFoundException("No such movie ID exist");
//		Movie movie=opt.get();
//		movieDao.delete(movie);
//		return true;
//	}
	

}
