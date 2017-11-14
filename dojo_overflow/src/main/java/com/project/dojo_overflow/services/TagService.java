package com.project.dojo_overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dojo_overflow.models.*;
import com.project.dojo_overflow.repositories.*;

@Service
public class TagService {
	private TagRepository tagRepository;

	public TagService(TagRepository tagRepository){
		this.tagRepository=tagRepository;
	}

	public ArrayList<Tag> all() {
		return (ArrayList<Tag>) tagRepository.findAll();
	}

	public Tag findById(long id) {
		return (Tag) tagRepository.findOne(id);
	}

	public void create(Tag tag) {
		tagRepository.save(tag);
	}

	public void update(Tag tag) {
		tagRepository.save(tag);
	}

	public void destroy(long id) {
		tagRepository.delete(id);
	}

	public Tag findOrCreateTag(String question) {
		Tag tagByName = tagRepository.findBySubject(question); 
		if(tagByName == null) {
			Tag tag = new Tag();
			tag.setSubject(question);
			return tagRepository.save(tag);
		} else {
			return tagByName;
		}
	}

}