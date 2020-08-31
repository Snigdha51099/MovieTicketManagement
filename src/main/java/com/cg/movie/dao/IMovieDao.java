package com.cg.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.movie.entity.Movie;
@Repository
public interface IMovieDao extends JpaRepository<Movie, Integer> {

//	@Query("from Movie m where m.movieName like :mname or m.language like :mname or m.director like :mname or m.genre like :mname")
//	public List<Movie> searchMovies(@Param("mname") String search);
	@Query("select m from Movie m where m.movieName like :mname or m.language like :mname or m.director like :mname or m.genre like :mname")
	public List<Movie> searchMovies(@Param("mname") String search);
	
	
}
