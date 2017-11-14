package com.project.dojosninjas.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dojosninjas.models.Dojo;
import com.project.dojosninjas.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class Dojos {
	private final DojoService dojoService;
	
	public Dojos(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/new.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/new.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}	
	
	@RequestMapping("/{id}")
	public String newDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.getDojo(id));
		return "/dojos/show.jsp";
	}
}