package org.spring.foto.controller;


import java.util.List;
import java.util.Optional;

import org.spring.foto.pojo.Category;
import org.spring.foto.pojo.Photo;
import org.spring.foto.service.CategoryService;
import org.spring.foto.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryAreaController {


	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PhotoService photoService;
	
	
// Index -----------------------------------------------------
	@GetMapping("/index")
	public String indexCategory(Model model) {
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("obj", categories);
		
		List<Photo> photos = photoService.findAll();
		model.addAttribute("photos", photos);
		
		model.addAttribute("routeName", "categorie");
		
		model.addAttribute("type", "Crea");
		model.addAttribute("action", "store");
		model.addAttribute("element", "category");

		return "CRUD-category/admin-index";
	}

	
//  Show Categoria -----------------------------------------------------
	@GetMapping("/show/{id}")
	public String showCategories(@PathVariable("id") int id, Model model) {
		
		Category cat = categoryService.findCategoryById(id);
		
		model.addAttribute("category", cat);
		
		model.addAttribute("routeName", "dettaglio Categoria");
		 
		return "CRUD-category/admin-show";
	}
	

	
	
//  Crea Categoria -----------------------------------------------------
	@GetMapping("/create")
	public String create(Model model) {
		
		Category cat = new Category();
		model.addAttribute("obj", cat);
		
		List<Photo> photos = photoService.findAll();
		model.addAttribute("photos", photos);
		
		model.addAttribute("routeName", "createCat");
	
		model.addAttribute("element", "category");
		model.addAttribute("type", "Modifica");
		model.addAttribute("action", "update");
		
		return "CRUD-category/admin-edit_create";
	}
	
	//  Store ------------------
	@PostMapping("/store")
	public String storeCategory(@Valid @ModelAttribute("category") Category category, 
						BindingResult bindingResult, 
						RedirectAttributes redirectAttributes) {
		
		// --------------------------------- Errors & Msg --------------------------------------	
		
			if(bindingResult.hasErrors()) {
				redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
				return "redirect:/admin/category/create";
			}
			redirectAttributes.addFlashAttribute("successMsg", "Creazione avvenuta con successo");
		
		// -------------------------------------------------------------------------------------
	
		categoryService.save(category);
		
		return "redirect:/admin/category/index";
	}
	
	
	
//  Modifica Categoria ------------------------------------------------------------
	@GetMapping("/edit/{id}")
	public String editCategory(@PathVariable("id") int id, Model model) {
		
		Category cat = categoryService.findCategoryById(id);
		model.addAttribute("obj", cat);
		
		List<Photo> photos = photoService.findAll();
		model.addAttribute("photos", photos);

		model.addAttribute("routeName", "edit");
		model.addAttribute("element", "category");
		model.addAttribute("type", "Modifica");
		model.addAttribute("action", "update");
		
		return "CRUD-category/admin-edit_create";
	}
	
	// Update -----------------
	@PostMapping("/update")
	public String updateCategory(@Valid @ModelAttribute("category") 
								Category category, 
								BindingResult bindingResult, 
								RedirectAttributes redirectAttributes) {
	
	// --------------------------------- Errors & Msg --------------------------------------	

		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/admin/category/edit/" + category.getId();
		}
		
		redirectAttributes.addFlashAttribute("successMsg", "Modifica avvenuta con successo");
		
	// -------------------------------------------------------------------------------------	

		categoryService.save(category);
		
		return "redirect:/admin/category/index";
	}
	
	
//  Delete -----------------------------------------------------
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		
		Category cat = categoryService.findCategoryById(id);
		
		for (Photo photo : cat.getPhotos()) {
			photo.removeCategory(cat);
		}
		
		categoryService.deleteCategoryById(id);

		return "redirect:/admin/category/index";
	}
}
