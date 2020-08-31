package com.cg.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;



public class MovieDto {

	@NotNull(message="MovieId is necessary")
	private int movieId;
	@Size(max=25)
	private String movieName;
	@Size(max=25)
	private String language;
	@Size(max=25)
	private String director;
	@Size(max=25)
	private String genre;
	@NotNull(message="this field should not be null")
	private int active;
	@FutureOrPresent(message="Only present and future dates are allowed")
	private LocalDate releaseDt;
	@Size(max=255)
	private String movieDesc;
	
	public MovieDto()
	{
		
	}
	
	public MovieDto(@NotNull(message = "MovieId is necessary") int movieId, @Size(max = 25) String movieName,
			@Size(max = 25) String language, @Size(max = 25) String director, @Size(max = 25) String genre,
			@Size(max = 25) int active,
			@PastOrPresent(message = "Date must be past or present date") LocalDate releaseDt,
			@Size(max = 255) String movieDesc) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.language = language;
		this.director = director;
		this.genre = genre;
		this.active = active;
		this.releaseDt = releaseDt;
		this.movieDesc = movieDesc;
	}

	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public LocalDate getReleaseDt() {
		return releaseDt;
	}
	public void setReleaseDt(LocalDate releaseDt) {
		this.releaseDt = releaseDt;
	}
	public String getMovieDesc() {
		return movieDesc;
	}
	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}
}
