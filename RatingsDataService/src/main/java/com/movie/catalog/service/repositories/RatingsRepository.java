package com.movie.catalog.service.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.movie.catalog.service.entities.RatingEntity;
import com.movie.catalog.service.entities.UserRatingEntity;

@Repository
public class RatingsRepository {

	@PersistenceContext
	EntityManager em;
	
	public List<RatingEntity> findByMovieId(int movieId) {
		return em.createQuery("select r from RatingEntity r where r.movie.movieId = :Id", RatingEntity.class).setParameter("Id", movieId).getResultList();
	}

	public void saveUserRating(UserRatingEntity urentity) {
		em.merge(urentity);
	}
	
	public void saveRating(RatingEntity urentity) {
		em.persist(urentity);
	}
	
}
