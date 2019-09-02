package com.poc.springdatajpa.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Topic {

	@Getter @Setter
	@Id()
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id; 
	@Getter @Setter
	private String name; 
	@Getter @Setter
	private String description;
	
}
