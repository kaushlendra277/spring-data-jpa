package com.poc.springdatajpa.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

	@Getter @Setter
	@Id()
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id; 
	@Getter @Setter
	private String name; 
	@Getter @Setter
	private String description;
	
	@Getter @Setter
	@ManyToOne
	private Topic topic;
	
}
