package com.movie.catalog.service.pojos;

public class Rating {
	int movieId;
	float rating;
	
	public Rating() {
		
	}
	
	public Rating(int movieId, float rating) {
		this.movieId = movieId;
		this.rating = rating;
	}
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
}
