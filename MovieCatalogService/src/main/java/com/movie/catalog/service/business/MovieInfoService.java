package com.movie.catalog.service.business;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.catalog.service.pojos.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfoService {
	
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getAllMoviesFallback")
	public List<Movie> getAllMovies() {
		
		List<Movie> movies = restTemplate.exchange("http://MOVIEINFOSERVICE/movies/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {}).getBody();
		
		return movies;
	}
	
	
	public List<Movie> getAllMoviesFallback() {
		return Arrays.asList(new Movie(0,"Movie not found"));
	}
}
