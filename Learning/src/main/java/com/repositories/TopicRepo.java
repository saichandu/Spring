package com.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.entities.Topic;

@Repository
public class TopicRepo {

	@PersistenceContext
	EntityManager em;

	public List<Topic> findAllTopics() {
		return em.createQuery("from Topic", Topic.class).getResultList();
	}
	
	public Topic findById(int id) {
		return em.createQuery("select a from Topic a where a.id =:id", Topic.class).setParameter("id", id).getSingleResult();
	}

	@Transactional
	public void saveTopic(Topic topic) {
		try {
			em.persist(topic);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Transactional
	public void mergeTopic(Topic topic) {
		try {
			em.merge(topic);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
