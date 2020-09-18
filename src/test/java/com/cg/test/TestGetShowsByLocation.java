package com.cg.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.movie.entity.Show;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.service.MovieServiceImpl;

@SpringBootTest
public class TestGetShowsByLocation {
	@Autowired
	private MovieServiceImpl service;
	@Test
	public void testByLocationName() throws MovieNotFoundException
	{
		List<Show> list=service.getShows("Noida");
		Assertions.assertTrue(!list.isEmpty());
	}
	@Test
	public void testByNotFound()
	{
		Assertions.assertThrows(MovieNotFoundException.class, ()->service.getShows("Pune"));
	}

}
