package com.movie.catalog.service.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="MOVIES")
public class MovieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MOVIE_ID", unique=true, nullable=false)
	private long movieId;

	@Column(name="MOVIE_NAME", nullable=false, length=50)
	private String movieName;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="movie")
	private List<RatingEntity> ratings;

	public MovieEntity() {
	}

	public long getMovieId() {
		return this.movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return this.movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public List<RatingEntity> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<RatingEntity> ratings) {
		this.ratings = ratings;
	}

	public RatingEntity addRating(RatingEntity rating) {
		getRatings().add(rating);
		rating.setMovy(this);

		return rating;
	}

	public RatingEntity removeRating(RatingEntity rating) {
		getRatings().remove(rating);
		rating.setMovy(null);

		return rating;
	}

}