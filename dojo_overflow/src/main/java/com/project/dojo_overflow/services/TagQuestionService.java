package com.project.dojo_overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dojo_overflow.repositories.*;
import com.project.dojo_overflow.models.*;

@Service
public class TagQuestionService {
	private TagQuestionRepository tagQuestionRepository;
	
	public TagQuestionService(TagQuestionRepository tagQuestionRepository){
		this.tagQuestionRepository=tagQuestionRepository;
	}

	public ArrayList<TagQuestion > all(){
		return (ArrayList<TagQuestion >)tagQuestionRepository.findAll();
	}
}
