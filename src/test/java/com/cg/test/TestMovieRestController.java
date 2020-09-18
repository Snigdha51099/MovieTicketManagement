package com.cg.test;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.dto.MovieDto;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.Show;

public class TestMovieRestController {
	private RestTemplate rt=new RestTemplate();
    @Test
	public void testSearchMovie()
	{
    	String url= "http://localhost:8082/booking/searchmovie/Bhoot";
		ResponseEntity<List<Movie>> resp=rt.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {
		});
		assertFalse(resp.getBody().isEmpty());
	}
    @Test
   	public void testSearchMovie1()
   	{
       	String url= "http://localhost:8082/booking/searchmovie/Abcd";
   		assertThrows(HttpClientErrorException.class, ()-> rt.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {
   		}));
   		
   	}
    @Test
   	public void testGetShowsByLocation()
   	{
       	String url= "http://localhost:8082/booking/getshows/Noida";
       	ResponseEntity<List<Show>> resp=rt.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Show>>() {
		});
		assertFalse(resp.getBody().isEmpty());
   	}
    @Test
   	public void testGetShowsByLocation1()
   	{
       	String url= "http://localhost:8082/booking/getshows/Pune";
       	assertThrows(HttpClientErrorException.class, ()-> rt.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Show>>() {
   		}));
   	}
    @Test
   	public void testDeleteMovie()
   	{
       	String url= "http://localhost:8082/booking/deletemovie/6";
       	ResponseEntity<String> resp=rt.exchange(url, HttpMethod.DELETE, null, String.class);
		String result=(resp.getBody());
   	}
    @Test
    public void testDeleteMovie1()
   	{
       	String url= "http://localhost:8082/booking/deletemovie/10";
       	assertThrows(HttpClientErrorException.class, ()-> rt.exchange(url, HttpMethod.DELETE, null, String.class));
   	}
    @Test
	public void testAddMovie()
   	{
       	String url= "http://localhost:8082/booking/addmovie";
       	MovieDto movie=new MovieDto();
       	movie.setMovieId(7);
       	movie.setMovieName("Pari");
       	movie.setLanguage("Hindi");
       	movie.setGenre("Horror");
       	movie.setActive(1);
       	movie.setDirector("Prosit Roy");
       	movie.setMovieDesc("Story of an abused girl rukhsana");
       	movie.setReleaseDt(LocalDate.of(2020, 10, 3));
       	try {
    		String res =rt.postForObject(url, movie, String.class);
    		System.out.println("result " + res);
    		}catch(HttpClientErrorException ex) {
    			System.out.println(ex.getResponseBodyAsString());
    		}
   	}
    @Test
    public void testAddMovie1()
   	{
       	String url= "http://localhost:8082/booking/addmovie";
       	MovieDto movie=new MovieDto();
       	movie.setMovieId(7);
       	movie.setMovieName("Pari");
       	movie.setLanguage("Hindi");
       	movie.setGenre("Horror");
       	movie.setActive(1);
       	movie.setDirector("Prosit Roy");
       	movie.setMovieDesc("Story of an abused girl rukhsana");
       	movie.setReleaseDt(LocalDate.of(2020, 10, 3));
       	assertThrows(HttpClientErrorException.class, ()-> rt.exchange(url, HttpMethod.POST, null, String.class));
   	}
}
