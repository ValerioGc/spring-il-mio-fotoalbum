package org.spring.foto.controller;

import java.util.List;
import java.util.Optional;

import org.spring.foto.pojo.Category;
import org.spring.foto.pojo.Photo;
import org.spring.foto.pojo.Tag;
import org.spring.foto.service.CategoryService;
import org.spring.foto.service.PhotoService;
import org.spring.foto.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/photo")
public class AdminPhotoAreaController {
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	TagService tagService;
	
	
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
	@GetMapping("/create")
	public String createPizza(Model model) {
		Photo ph1 = new Photo();
		model.addAttribute("obj", ph1);
				
		List<Category> categories = categoryService.findAll(); 
		model.addAttribute("categories", categories);
		
		List<Tag> tags = tagService.findAll();
		model.addAttribute("tgs", tags);

		model.addAttribute("routeName", "create");
		model.addAttribute("element", "photo");
		model.addAttribute("type", "Crea");
		model.addAttribute("action", "store");
		
		return "admin-edit_create";
	}
	//  Store
	@PostMapping("/store")
	public String storePhoto(@Valid Photo photo, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

	// --------------------------------- Errors & Msg --------------------------------------	
		
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/admin/photo/create";
		}
		redirectAttributes.addFlashAttribute("successMsg", "Creazione avvenuta con successo");
	
	// -------------------------------------------------------------------------------------	

		photoService.save(photo);
		
		return "redirect:/admin/photo/index";
	}
	
	
//  Modifica foto ------------------------------------------------------------
	@GetMapping("/edit/{id}")
	public String editPizza(@PathVariable("id") int id, Model model) {
		
		List<Category> categories = categoryService.findAll(); 
		model.addAttribute("categories", categories);
		
		List<Tag> tags = tagService.findAll();
		model.addAttribute("tgs", tags);
		
		Optional<Photo> optPhoto = photoService.findPhotoById(id);
		Photo photo = optPhoto.get();
		model.addAttribute("obj", photo);

		model.addAttribute("routeName", "edit");
		model.addAttribute("element", "photo");
		model.addAttribute("type", "Modifica");
		model.addAttribute("action", "update");
		
		return "admin-edit_create";
	}
	// Update 
	@PostMapping("/update")
	public String updatePhoto(@Valid Photo photo, 
								BindingResult bindingResult, 
								RedirectAttributes redirectAttributes) {
	
	// --------------------------------- Errors & Msg --------------------------------------	

		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/admin/photo/edit/" + photo.getId();
		}
		
		redirectAttributes.addFlashAttribute("successMsg", "Modifica avvenuta con successo");
		
	// -------------------------------------------------------------------------------------	

		photoService.save(photo);
		
		return "redirect:/admin/photo/index";
	}
	
	
//  Cancella foto ------------------------------------------------------------
	@GetMapping("/delete/{id}")
	public String deletePizza(@PathVariable("id") int id) {
		
		photoService.deletePhotoById(id);

		return "redirect:/admin/photo/index";
	}
}
