package com.movie.catalog.service.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.movie.catalog.service.entities.MovieEntity;

@Repository
@Transactional
public class MovieRepository {

	@PersistenceContext
	EntityManager em;
	
	public List<MovieEntity> findAll() {
		return em.createQuery("select m from MovieEntity m", MovieEntity.class).getResultList();
	}
	
	public List<MovieEntity> findByMovieId(int movieId) {
		return em.createQuery("select m from MovieEntity m where m.movieId = :Id", MovieEntity.class).setParameter("Id", movieId).getResultList();
	}
	
	public void saveMovie(MovieEntity movEntity) {
		em.persist(movEntity);
	}
	
}
