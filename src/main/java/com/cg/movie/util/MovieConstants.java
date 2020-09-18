package com.cg.movie.util;

public class MovieConstants {

	public static final String MOVIE_NOT_AVAILABLE= "No Movie Found";
	public static final int ACTIVE_MOVIE = 1;
	public static final int IN_ACTIVE_MOVIE = 0;
	public static final String SEARCH_MOVIE_URL="/searchmovie/{mname}";
	public static final String MOVIE_ALREADY_EXIST="Movie already present";
	public static final String ADD_MOVIE="One movie is added";
	public static final String ADD_MOVIE_URL="/addmovie";
	public static final String DELETE_MOVIE="Movie Deleted";
	public static final String MOVIE_ID_NOT_FOUND="No such movie id exist";
	public static final String DELETE_MOVIE_URL="/deletemovie/{movieid}";
	public static final String GET_SHOWS_URL="/getshows/{loc}";
}
