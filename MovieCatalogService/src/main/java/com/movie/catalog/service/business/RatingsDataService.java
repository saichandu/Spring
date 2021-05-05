package com.movie.catalog.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.catalog.service.pojos.Movie;
import com.movie.catalog.service.pojos.Rating;

@Service
public class RatingsDataService {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	public Rating getRatings(Movie movie) {
		Rating[] rating = restTemplate.getForObject("http://RATINGSSERVICE/ratings/" + movie.getMovieId(), Rating[].class);
		
		return rating[0];
	}
	
	public Rating getRatingsFallback(Movie movie) {
		Rating[] rating = new Rating[] {new Rating(0,0)};
		
		return rating[0];
	}
}
