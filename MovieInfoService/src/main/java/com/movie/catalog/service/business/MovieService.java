package com.movie.catalog.service.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.catalog.service.entities.MovieEntity;
import com.movie.catalog.service.pojos.Movie;
import com.movie.catalog.service.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movyrepo;
	
	public void saveMovie(Movie movy) {
		MovieEntity movEntity = new MovieEntity();
		movEntity.setMovieName(movy.getMovieName());
		movyrepo.saveMovie(movEntity);
	}

	public Movie getMovieName(int movieId) {
		MovieEntity mEntity =  movyrepo.findByMovieId(movieId).get(0);
		Movie movie = new Movie();
		movie.setMovieId(Integer.parseInt(mEntity.getMovieId()+""));
		movie.setMovieName(mEntity.getMovieName());
		return movie;
	}

	public List<Movie> getAllMovies() {
		List<MovieEntity> entities = movyrepo.findAll();
		List<Movie> movies = new ArrayList<>();
		for (MovieEntity entity : entities) {
			Movie movie = new Movie();
			movie.setMovieId(entity.getMovieId());
			movie.setMovieName(entity.getMovieName());
			movies.add(movie);
		}
		return movies;
	}
}
