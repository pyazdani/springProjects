package com.project.dojo_overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dojo_overflow.repositories.QuestionRepository;
import com.project.dojo_overflow.models.Question;

@Service
public class QuestionService{
	private QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository){
		this.questionRepository=questionRepository;
	}
	
	public ArrayList<Question> all(){
		return (ArrayList<Question>) questionRepository.findAll();
	}
	public Question findById(long id){
		return (Question) questionRepository.findOne(id);
	} 
	public void create(Question question){
		questionRepository.save(question);
	}
	public void update(Question question) {
		questionRepository.save(question);
	}
	public void destroy(long id){
		questionRepository.delete(id);
	}
}