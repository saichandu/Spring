package com.movie.catalog.service.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movie.catalog.service.business.MovieInfoService;
import com.movie.catalog.service.business.RatingsDataService;
import com.movie.catalog.service.pojos.CatalogItem;
import com.movie.catalog.service.pojos.Movie;
import com.movie.catalog.service.pojos.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MovieInfoService movieService;
	
	@Autowired
	RatingsDataService ratingsService;
	
	@GetMapping("/{movieid}")
	public CatalogItem getRating(@PathVariable String movieid) {
		
		Movie movie = restTemplate.getForObject("http://MOVIEINFOSERVICE/movies/" + movieid, Movie.class);
		Rating[] rating = restTemplate.getForObject("http://RATINGSSERVICE/ratings/" + movieid, Rating[].class);
		
		CatalogItem item = new CatalogItem();
		
		item.setMovieName(movie.getMovieName());
		item.setRating(rating[0].getRating());
		
		return item;
	}
	
	@GetMapping("/all")
	public List<CatalogItem> getAll() {
		
		List<CatalogItem> items = new ArrayList<>();
		
		List<Movie> movies = movieService.getAllMovies();
		
		for (Movie movie : movies) {
			Rating rating = ratingsService.getRatings(movie);
			
			CatalogItem item = new CatalogItem();
			
			item.setMovieName(movie.getMovieName());
			item.setRating(rating.getRating() == 0?0:rating.getRating());
			
			items.add(item);
		}
		return items;
	}
}
