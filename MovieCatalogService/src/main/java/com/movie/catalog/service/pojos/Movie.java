package com.movie.catalog.service.pojos;

public class Movie {
	int movieId;
	String movieName;
	
	public Movie() {
		
	}
	
	public Movie(int movieId, String movieName) {
		this.movieId = movieId;
		this.movieName = movieName;
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
}
