package com.movie.catalog.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.movie.catalog.service.business.RatingsService;
import com.movie.catalog.service.pojos.Rating;
import com.movie.catalog.service.pojos.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

	@Autowired
	RatingsService service;
	
	
	@GetMapping("/{movieid}")
	public List<Rating> getMovieRating(@PathVariable("movieid") int movieId) {
		return service.fetchRatings(movieId);
	}
	
	@PostMapping("/postrating")
	@ResponseStatus(HttpStatus.CREATED)
	public void postMovieRating(@RequestBody UserRating rating) {
		service.saveMovieRating(rating);
	}
}