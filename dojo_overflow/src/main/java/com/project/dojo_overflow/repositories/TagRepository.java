package com.project.dojo_overflow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.dojo_overflow.models.*;

@Repository 												
public interface TagRepository extends CrudRepository<Tag, Long>{

	Tag findBySubject(String question);
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
