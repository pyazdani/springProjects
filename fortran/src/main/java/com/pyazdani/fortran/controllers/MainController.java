package com.pyazdani.fortran.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/m/{chapter}/0483/{assignmentNumber}")
    public String assignmentNum(@PathVariable(value="assignmentNumber") String number, Model model){
		
		String goal;
		
		if(number.equals("0345")) {
			goal = "The goal of this assignment is to create forms";
		} else {
			goal = "The goal of this assignment is to learn fortran to binary";
		}
		
		model.addAttribute("goal", goal);
		return "assignment.jsp";
	}
	
	@RequestMapping("/m/{chapter}/0553/{lessonNumber}")
    public String lessonNum(@PathVariable(value="lessonNumber") String number, Model model){
		
		String less;
		
		if(number.equals("0733")) {
			less = "Setting Up Your Servers";
		}
		else if(number.equals("2342")){
			less = "Punch Cards";
		}
		else {
			less = "Advanced Fortran Intro";
		}
		model.addAttribute("less", less);
		return "lesson.jsp";
	}
	
//	@RequestMapping("/assignment")
//	public String assignment() {
//		return "assignment.jsp";
//	}
//	
//	@RequestMapping("/lesson")
//	public String lesson() {
//		return "lesson.jsp";
//	}
}