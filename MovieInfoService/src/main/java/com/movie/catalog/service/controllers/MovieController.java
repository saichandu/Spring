package com.movie.catalog.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.movie.catalog.service.business.MovieService;
import com.movie.catalog.service.pojos.Movie;

@RefreshScope
@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Value("${spring.zipkin.baseUrl:Unable to connect to config server}")
	private String url;

	@RequestMapping("/zipkin/url")
	String getURL() {
		return this.url;
	}
	
	@Autowired
	MovieService service;
	
	@PostMapping("/savemoviedata")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveMovieData(@RequestBody Movie movy) {
		service.saveMovie(movy);
	}
	
	@GetMapping("/{movieid}")
	public Movie getMovieName(@PathVariable("movieid") int movieId) {
		return service.getMovieName(movieId);
	}
	
	@GetMapping("/all")
	public List<Movie> getAllMovies() {
		return service.getAllMovies();
	}
}