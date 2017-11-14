package com.project.dojosninjas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.dojosninjas.models.Dojo;
import com.project.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> getAll() {
		return dojoRepository.findAll();
	}
	
	public void createDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	
	public Dojo getDojo(Long id) {
		return dojoRepository.findOne(id);
	}
}