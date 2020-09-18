package com.cg.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dto.MovieDto;
import com.cg.movie.dao.IMovieDao;
import com.cg.movie.exceptions.AddMovieException;
import com.cg.movie.service.MovieServiceImpl;

@SpringBootTest
public class TestAddMovie {
	@Autowired
	private MovieServiceImpl service;
	@Autowired
	private IMovieDao movieDao;
	@Test
	public void testAddMovie() throws AddMovieException
	{
		MovieDto dto=new MovieDto(5, "Titanic", "English", "James Cameron", "Romance", 1, LocalDate.of(2020, 10, 2), "Story of Rose and Jack");
	}
	@Test
	public void testAddMovie2() throws AddMovieException
	{
		MovieDto dto=new MovieDto(1, "Titanic", "English", "James Cameron", "Romance", 1, LocalDate.of(2020, 10, 2), "Story of Rose and Jack");
		Assertions.assertThrows(AddMovieException.class, ()->service.addMovie(dto));
	}

}
