package com.poc.springdatajpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.springdatajpa.models.Course;
import com.poc.springdatajpa.models.Topic;
import com.poc.springdatajpa.services.CourseService;

@Component
@ResponseBody
@RequestMapping("topics/{topicId}/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<Course> getAll(@PathVariable String topicId){
		return courseService.getAll(topicId);
	}
	
	@GetMapping("{courseId}")
	public Course getCourse(
			@PathVariable String topicId,
			@PathVariable String courseId) {
		return courseService.getCourse(courseId);
	}
	
	@PostMapping
	public void add(
			@PathVariable String topicId,
			@RequestBody Course course) {
		
		course = Course.builder()
			.topic(Topic.builder().id(topicId).build())
			.id(course.getId())
			.name(course.getName())
			.description(course.getDescription())
			.build();
		courseService.add(course);
	}
	
	/*
	@PutMapping
	public Course update(@RequestBody Course course) {
		return courseService.update(course);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		courseService.delete(id);
	}
	*/

}
