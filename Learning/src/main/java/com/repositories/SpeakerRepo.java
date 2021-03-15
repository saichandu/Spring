package com.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.entities.Speaker;

@Repository
public class SpeakerRepo{
	

	@PersistenceContext
	EntityManager em;

	public List<Speaker> findByTopicid(int id) {
		return em.createQuery("select a from Speaker a where a.topicid=:id", Speaker.class).setParameter("id", id).getResultList();
	}
	
	@Transactional(value=Transactional.TxType.REQUIRED)
	public void mergeSpeaker(Speaker speaker) {
		try {
			em.merge(speaker);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
