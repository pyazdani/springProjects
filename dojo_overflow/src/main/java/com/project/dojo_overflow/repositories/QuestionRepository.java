package com.project.dojo_overflow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.dojo_overflow.models.Question;

@Repository 												
public interface QuestionRepository extends CrudRepository<Question, Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
