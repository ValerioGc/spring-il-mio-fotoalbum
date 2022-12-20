package org.spring.foto.controller;

import java.util.List;

import org.spring.foto.pojo.Photo;
import org.spring.foto.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/photo")
public class AdminPhotoAreaController {
	
	@Autowired
	PhotoService photoService;
	
	
//  Index foto ----------------------------------------------------------------
	@GetMapping("/index")
	public String indexPhotos(Model model) {
		
		List<Photo> photos = photoService.findAll();
		model.addAttribute("photos", photos);
		model.addAttribute("routeName", "foto");
		 
		return "admin-index";
	}
	
	
//  Cancella foto ----------------------------------------------------------------
	@GetMapping("/delete/{id}")
	public String deletePizza(@PathVariable("id") int id) {
		
		photoService.deletePhotoById(id);

		return "redirect:/admin/photo/index";
	}
}
