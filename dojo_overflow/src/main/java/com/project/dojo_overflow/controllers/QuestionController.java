package com.project.dojo_overflow.controllers;


import java.security.Principal;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.ObjectError;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;


import com.project.dojo_overflow.services.QuestionService;
import com.project.dojo_overflow.services.TagService;
import com.project.dojo_overflow.services.TagQuestionService;

import com.project.dojo_overflow.models.*;

@RequestMapping("/questions")
@Controller
public class QuestionController{
	//Member variables go here
	private final QuestionService questionService;
	private final TagService tagService;
	private final TagQuestionService tagQuestionService;

	public QuestionController(QuestionService questionService, TagService tagService, TagQuestionService tagQuestionService){
		this.questionService = questionService;
		this.tagService = tagService;
		this.tagQuestionService = tagQuestionService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "tags", new CustomCollectionEditor(List.class) {                
	                  
	        public void setAsText(String element) {
	        	// information coming from the form
	        	String[] listOfTagString = element.split(", ");
	        	List<Tag> listOfTags = new ArrayList<Tag>();
	        	
	        	int maxLength = listOfTagString.length > 2 ? 3 : listOfTagString.length;
	        	
	        	for(int i = 0; i < maxLength; i++) {
	        		listOfTags.add(tagService.findOrCreateTag(listOfTagString[i]));
	        	}
	        	
	        	// set the value of the element to be a list of tags
	        	setValue(listOfTags);
	        }
        }); 
	}

	@RequestMapping("")
	public String index(@ModelAttribute("question") Question question, @ModelAttribute("tag") Tag tag , Model model){
		model.addAttribute("questions",questionService.all());
		model.addAttribute("tags",tagService.all());
		model.addAttribute("tags_questions",tagQuestionService.all());
		return "index";
	}

	@RequestMapping("/new")
	public String newQuestion(@ModelAttribute("Question") Question question){
		return "/questions/new";
	}
	
	@PostMapping("/new")
	public String createQuestion(@Valid @ModelAttribute("Question") Question question, BindingResult result, @RequestParam("tags") String tags){
		System.out.println(question);
		
		// if(result.hasErrors()){
		// 	return "/questions/new";
		// }
		questionService.create(question);
		return "redirect:/questions";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, @ModelAttribute("answerModel") Answer answer, Model model) {
		model.addAttribute("question", questionService.findById(id));
		return "/questions/show";
	}	

}
