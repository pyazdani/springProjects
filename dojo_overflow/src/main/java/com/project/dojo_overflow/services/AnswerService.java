package com.project.dojo_overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dojo_overflow.models.Answer;
import com.project.dojo_overflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	
	private AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository){
		this.answerRepository=answerRepository;
	}
	
	public ArrayList<Answer> all(){
		return (ArrayList<Answer>) answerRepository.findAll();
	}
	public Answer findById(long id){
		return (Answer) answerRepository.findOne(id);
	} 
	public void createAnswer(Answer answer){
		answerRepository.save(answer);
	}
	public void update(Answer answer) {
		answerRepository.save(answer);
	}
	public void destroy(long id){
		answerRepository.delete(id);
	}
}
