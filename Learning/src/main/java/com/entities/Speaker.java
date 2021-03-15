package com.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Speaker {
	@Id
	@SequenceGenerator(name="speaker_seq", sequenceName="speaker_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "speaker_seq")
	int id;
	String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="topicid", insertable = false, updatable = false)
	Topic ctopic;
	
	public Speaker() {
		
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

}
