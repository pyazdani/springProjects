package com.project.dojosandninjas.services;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.dojosandninjas.models.Dojo;
import com.project.dojosandninjas.models.Ninja;
import com.project.dojosandninjas.repositories.DojoRepository;
import com.project.dojosandninjas.repositories.NinjaRepository;

@Service
public class DoNiService {
	// Member variables / service initializations go here
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	
	public DoNiService(DojoRepository dojoRepo, NinjaRepository ninjaRepo){
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}

	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}

	public List<Ninja> findNinjasByDojo(Long id){
		return ninjaRepo.findDistinctNinjasByDojoId(id);
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo getDojo(Long id) {
		return dojoRepo.findOne(id);
	}
	
	public Ninja createNinja(Ninja ninja) {
		// Long ninjaId = ninja.getDojo().getId();
		// // Pad with 0 with a width of 6
		// String ninjaNumber = String.format("%06d", ninjaId);
		return ninjaRepo.save(ninja);

		// ninja.setNumber(ninjaNumber);
		// Ninja nin = ninjaRepo.save(ninja);
		
		// return nin;
	}
	
	// Crud methods to act on services go here.
}
