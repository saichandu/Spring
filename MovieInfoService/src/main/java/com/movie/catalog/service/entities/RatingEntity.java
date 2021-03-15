package com.movie.catalog.service.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the RATINGS database table.
 * 
 */
@Entity
@Table(name="RATINGS")
public class RatingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RATING_ID", unique=true, nullable=false)
	private long ratingId;

	@Column(nullable=false)
	private BigDecimal rating;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="MOVIE_ID", nullable=false)
	private MovieEntity movie;

	//bi-directional many-to-one association to UserRating
	@OneToMany(mappedBy="rating")
	private List<UserRatingEntity> userRatings;

	public RatingEntity() {
	}

	public long getRatingId() {
		return this.ratingId;
	}

	public void setRatingId(long ratingId) {
		this.ratingId = ratingId;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public MovieEntity getMovy() {
		return this.movie;
	}

	public void setMovy(MovieEntity movy) {
		this.movie = movy;
	}

	public List<UserRatingEntity> getUserRatings() {
		return this.userRatings;
	}

	public void setUserRatings(List<UserRatingEntity> userRatings) {
		this.userRatings = userRatings;
	}

	public UserRatingEntity addUserRating(UserRatingEntity userRating) {
		getUserRatings().add(userRating);
		userRating.setRating(this);

		return userRating;
	}

	public UserRatingEntity removeUserRating(UserRatingEntity userRating) {
		getUserRatings().remove(userRating);
		userRating.setRating(null);

		return userRating;
	}

}