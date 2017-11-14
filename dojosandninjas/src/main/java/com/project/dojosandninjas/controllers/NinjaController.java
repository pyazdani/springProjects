package com.project.dojosandninjas.controllers;

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

import com.project.dojosandninjas.models.Dojo;
import com.project.dojosandninjas.models.Ninja;
import com.project.dojosandninjas.services.DoNiService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController{
	//Member variables go here

	private final DoNiService doNiService;
	
	public NinjaController(DoNiService doNiSerivce) {
		this.doNiService = doNiService;
	}
	
	@RequestMapping("/new")
	public String newNinja(@ModelAttribute Dojo dojo, Model model) {
		model.addAttribute("dojos", doNiService.allDojos());
		return "/ninjas/new.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", doNiService.allDojos());
			return "/ninjas/new.jsp";
		} else {
			Ninja nin = DoNiService.createNinja(ninja);
			// String ninjaId = Long.toString(nin.getNinja().getId());
			// return "redirect:/ninjas/".concat(ninjaId);
			model.addAttribute("dojos", doNiService.allDojos());
			return "/ninjas/new.jsp";
		}
	}
}
