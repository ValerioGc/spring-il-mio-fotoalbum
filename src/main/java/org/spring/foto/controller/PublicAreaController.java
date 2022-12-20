package org.spring.foto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PublicAreaController {

	
	@GetMapping 
	public String getHomePage(Model model) {
		model.addAttribute("routeName", "home");
		return "home";
	}
}
