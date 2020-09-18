package com.cg.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.movie.entity.Show;

@Repository
public interface ShowDao extends JpaRepository<Show, Integer>{
	@Query("select s from Show s where s.location=:loc")
	public List<Show> getShows(@Param("loc") String location);

}
