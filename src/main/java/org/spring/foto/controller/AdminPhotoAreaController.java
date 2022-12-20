package org.spring.foto.controller;

import java.util.List;
import java.util.Optional;

import org.spring.foto.pojo.Photo;
import org.spring.foto.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

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
	
	
//  Show foto ----------------------------------------------------------------
	@GetMapping("/show/{id}")
	public String showPhotos(@PathVariable("id") int id, Model model) {
		
		Optional<Photo> optPhoto = photoService.findPhotoById(id);
		Photo photo = optPhoto.get();
		
		model.addAttribute("photo", photo);
		
		model.addAttribute("routeName", "dettaglio foto");
		 
		return "admin-show";
	}
	
	
//  Crea foto ----------------------------------------------------------------
	@GetMapping("/create/{id}")
	public String createPizza(@PathVariable("id") int id) {
		return "";
	}
	@PostMapping("/store")
	public String storePhoto(@Valid Photo photo) {
		return "";
	}
	
	
//  Modifica foto ------------------------------------------------------------
	@GetMapping("/edit/{id}")
	public String editPizza(@PathVariable("id") int id) {
		return "";
	}
	@PostMapping("/update")
	public String updatePhoto(@Valid Photo photo) {
		return "";
	}
	
	
//  Cancella foto ------------------------------------------------------------
	@GetMapping("/delete/{id}")
	public String deletePizza(@PathVariable("id") int id) {
		
		photoService.deletePhotoById(id);

		return "redirect:/admin/photo/index";
	}
}
