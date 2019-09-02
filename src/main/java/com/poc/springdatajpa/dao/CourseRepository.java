package com.poc.springdatajpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.poc.springdatajpa.models.Course;

public interface CourseRepository extends CrudRepository<Course, String>  {

	public List<Course> findByTopicId(String topicId);
}
