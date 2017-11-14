package com.pyazdani.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DisplaydateController {

	private static Date currentDate = new Date();
	private static SimpleDateFormat formatter;
	
    @RequestMapping("/")
    public String index() {
            return "index.jsp";
    }
    
    @RequestMapping("/date")
	public String getDatePage(Model model) {
		formatter = new SimpleDateFormat("EEEE, 'the ' d 'of' MMMM, yyyy");
		String formattedDate = formatter.format(currentDate);
		model.addAttribute("date", formattedDate);
		return "datePage.jsp";
	}
	
	@RequestMapping("/time")
	public String getTimePage(Model model) {
		formatter = new SimpleDateFormat("hh:mm aa");
		String formattedDate = formatter.format(currentDate);
		model.addAttribute("date", formattedDate);
		return "timePage.jsp";
	}	
}
