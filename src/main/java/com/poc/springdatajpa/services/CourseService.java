package com.poc.springdatajpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.springdatajpa.dao.CourseRepository;
import com.poc.springdatajpa.models.Course;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAll(String topicId) {
		return courseRepository.findByTopicId(topicId);
	}
	
	public Course getCourse(String id) {
		Optional<Course> oCourse = courseRepository.findById(id);
		return oCourse.isPresent() 
				? oCourse.get()
				: null;
	}
	public void add(Course course) {
		courseRepository.save(course);
	}
	/*
	public Course update(Course course) {
		// a save can do both add and update, 
		// if record with the specified id found in the db save will update the record 
		// else it will add the record 
		return courseRepository.save(course);  
	}

	public void delete(String id) {
		courseRepository.deleteById(id);
	}

*/
}
