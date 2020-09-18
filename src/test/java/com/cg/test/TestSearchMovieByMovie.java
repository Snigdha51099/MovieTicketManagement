package com.cg.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.movie.entity.Movie;
import com.cg.movie.exceptions.MovieSearchException;
import com.cg.movie.service.MovieServiceImpl;

@SpringBootTest
public class TestSearchMovieByMovie {
	@Autowired
	private MovieServiceImpl service;
	@Test
	public void testByMovieName() throws MovieSearchException
	{
		List<Movie> list=service.searchMovies("Bhoot");
		Assertions.assertTrue(!list.isEmpty());
	}
	@Test
	public void testByMovieLanguage() throws MovieSearchException
	{
		List<Movie> list=service.searchMovies("Hindi");
		Assertions.assertTrue(!list.isEmpty());
	}
	@Test
	public void testByMovieGenre() throws MovieSearchException
	{
		List<Movie> list=service.searchMovies("Horror");
		Assertions.assertTrue(!list.isEmpty());
	}
	@Test
	public void testByMovieDirector() throws MovieSearchException
	{
		List<Movie> list=service.searchMovies("Bhanu Pratap Singh");
		Assertions.assertTrue(!list.isEmpty());
	}
	
	@Test
	public void testByMovieNotFound() throws MovieSearchException
	{
		
		Assertions.assertThrows(MovieSearchException.class, ()->service.searchMovies("annonymus"));
	}

}
