package com.pyazdani.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(path="/process", method=RequestMethod.POST)
	public String process(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comments", required=false) String comments, HttpSession session ) {
		session.setAttribute("name",name);
		session.setAttribute("location",location);
		session.setAttribute("language",language);
		session.setAttribute("comments",comments);
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard.jsp";
	}
}