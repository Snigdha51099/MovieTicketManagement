package com.cg.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.movie.dao.IMovieDao;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.service.MovieServiceImpl;

@SpringBootTest
public class TestDeleteMovie {
	@Autowired
	private MovieServiceImpl service;
	@Autowired
	private IMovieDao movieDao;
	@Test
	public void testDeleteMovie()
	{
		String movie=service.deleteMovie(7);
		
	}
	@Test
	public void testDeleteMovie1()
	{
		Assertions.assertThrows(MovieNotFoundException.class, ()->service.deleteMovie(7));
	}
}
