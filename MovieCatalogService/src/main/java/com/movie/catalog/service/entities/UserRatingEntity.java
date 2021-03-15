package com.movie.catalog.service.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the USER_RATINGS database table.
 * 
 */
@Entity
@Table(name="USER_RATINGS")
public class UserRatingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", unique=true, nullable=false)
	private BigDecimal id;
	
	@Column(name="USER_ID")
	private BigDecimal userId;

	//bi-directional many-to-one association to Rating
	@ManyToOne
	@JoinColumn(name="RATING_ID")
	private RatingEntity rating;

	public UserRatingEntity() {
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public RatingEntity getRating() {
		return this.rating;
	}

	public void setRating(RatingEntity rating) {
		this.rating = rating;
	}

}