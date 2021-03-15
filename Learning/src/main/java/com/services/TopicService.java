package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Speaker;
import com.entities.Topic;
import com.repositories.SpeakerRepo;
import com.repositories.TopicRepo;

@Service
public class TopicService {
	
	@Autowired
	TopicRepo topicRepo;
	
	@Autowired
	SpeakerRepo speakerRepo;
	
	public List<Topic> getAllTopics() {
		return topicRepo.findAllTopics();
	}

	public List<Speaker> getSpeakersByTopicid(int id) {
		return speakerRepo.findByTopicid(id);
	}

	public void addTopic(Topic topic) {
		topicRepo.saveTopic(topic);
	}

	public void addSpeaker(Topic topic) {
		Topic tp = topicRepo.findById(topic.getId());
		tp.setSpeaker(topic.getSpeaker());
		topicRepo.mergeTopic(tp);
	}
	
}
