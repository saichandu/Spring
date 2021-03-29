package com.ecommerceapp.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ecommerceapp.entities.Country;
import com.ecommerceapp.entities.State;

@Repository
public class CreditCardRepository {

	@PersistenceContext
	EntityManager em;

	public List<Country> findAll() {
		List<Country> countries = em.createQuery("from Country c", Country.class).getResultList();
		return countries;
	}

	public List<State> findByCode(int code) {
		List<State> states = em.createQuery("from State s where s.country.id = :id", State.class)
				.setParameter("id", code)
				.getResultList();
		return states;
	}
	
	
	
}
