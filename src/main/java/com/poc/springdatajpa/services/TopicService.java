package com.poc.springdatajpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.springdatajpa.dao.TopicRepository;
import com.poc.springdatajpa.models.Topic;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAll() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics :: add);
		
		return topics;
	}
	
	public Topic geTopic(String id) {
		Optional<Topic> oTopic = topicRepository.findById(id);
		return oTopic.isPresent() 
				? oTopic.get()
				: null;
	}

	public void add(Topic topic) {
		topicRepository.save(topic);
	}

	public Topic update(Topic topic) {
		// a save can do both add and update, 
		// if record with the specified id found in the db save will update the record 
		// else it will add the record 
		return topicRepository.save(topic);  
	}

	public void delete(String id) {
		topicRepository.deleteById(id);
	}


}
