package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Speaker;
import com.entities.Topic;
import com.services.TopicService;

@RestController
public class TopicController {

	@Autowired
	TopicService service;
	
	@GetMapping("/getalltopics")
	public List<Topic> getAllTopics() {
		return service.getAllTopics();
	}
	
	@GetMapping("/getspeakers/{id}")
	public List<Speaker> getSpeakers(@PathVariable int id) {
		return service.getSpeakersByTopicid(id);
	}
	
	@PostMapping("/addtopic")
	@ResponseStatus(HttpStatus.CREATED)
	public void addTopic(@RequestBody Topic topic) {
		service.addTopic(topic);
	}
	
	@PostMapping("/addspeaker")
	public void addSpeaker(@RequestBody Topic topic) {
		service.addSpeaker(topic);
	}
	
}
