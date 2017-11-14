package com.project.dojo_overflow.controllers;

import com.project.dojo_overflow.services.AnswerService;
import com.project.dojo_overflow.models.Answer;

import java.security.Principal;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/answers")
@Controller
public class AnswerController{

	private final AnswerService answerService;

	public AnswerController(AnswerService answerService){
		this.answerService = answerService;
	}
	@RequestMapping(method=RequestMethod.POST)
	public String createAnswer(@Valid @ModelAttribute("answerModel") Answer answer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question", answer.getQuestion());
			return "/questions/show.jsp";
		} else {
			answerService.createAnswer(answer);
			String questionId = String.valueOf(answer.getQuestion().getId());
			return "redirect:/questions/".concat(questionId);
		}
	}
}
