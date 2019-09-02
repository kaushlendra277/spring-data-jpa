package com.poc.springdatajpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.poc.springdatajpa.models.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>  {

}
