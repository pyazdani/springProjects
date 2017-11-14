package com.pyazdani.grouplanguages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pyazdani.grouplanguages.models.Language;
import com.pyazdani.grouplanguages.services.LanguageService;

@Controller
public class MainController {
	private final LanguageService languageService;

    public MainController(LanguageService languageService){
        this.languageService = languageService;
    }
    
    @RequestMapping("/")
	public String index(@ModelAttribute("language") Language language, Model model) {
		model.addAttribute("languages", languageService.getLanguages());
		return "index";
	}
	   
    @PostMapping("/languages")
	public String createLanguages(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("languages", languageService.getLanguages());
    		return "index";
        }else{
        	languageService.addLanguage(language);
            return "redirect:/";
        }
	}
	
	@RequestMapping("/languages/{id}")
	public String showLanguage(Model model, @PathVariable("id") long id) {
    	Language lang = languageService.getLanguage(id);
    	model.addAttribute("id", id);
    	model.addAttribute("language", lang);
		return "show";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String editLanguage(Model model, @PathVariable("id") long id) {
    	Language lang = languageService.getLanguage(id);
    	model.addAttribute("id", id);
    	model.addAttribute("language", lang);
		return "edit";
	}	
	
	@PostMapping("/languages/update/{id}")
	public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") long id) {
        if (result.hasErrors()) {
    		return "edit";
        }else{
        	languageService.updateLanguage(language);
            return "redirect:/";
        }
	}
	
	@RequestMapping("/languages/delete/{id}")
	public String deleteLanguage(@PathVariable("id") long id) {
    	languageService.deleteLanguage(id);
        return "redirect:/";
	}
}