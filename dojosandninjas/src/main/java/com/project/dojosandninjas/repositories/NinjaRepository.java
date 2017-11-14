package com.project.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.dojosandninjas.models.Ninja;

@Repository 												
public interface NinjaRepository extends CrudRepository<Ninja,Long>{
	// Query methods go here.
	List<Ninja> findDistinctNinjasByDojoId(Long id);
	
	// Example:
	// public YourModelHere findByName(String name);
}
