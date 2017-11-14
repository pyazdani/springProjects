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

import com.project.dojosninjas.models.Ninja;
import com.project.dojosninjas.services.DojoService;
import com.project.dojosninjas.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class Ninjas {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public Ninjas(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.getAll());
		return "/ninjas/new.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/ninajs/new.jsp";
		} else {
			Ninja n = ninjaService.createNinja(ninja);
			String dojoId = Long.toString(n.getDojo().getId());
			return "redirect:/dojos/".concat(dojoId);
		}
	}
}
