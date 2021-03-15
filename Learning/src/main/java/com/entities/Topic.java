package com.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Topic {
	@Id
	@SequenceGenerator(name="topic_seq", sequenceName="topic_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_seq")
	int id;
	String name;
	String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="topicid", nullable = false)
	Set<Speaker> speaker;
	
	public Topic() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Speaker> getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Set<Speaker> speakers) {
		this.speaker = speakers;
	}
}
