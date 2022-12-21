package org.spring.foto.api;

import java.util.List;

import org.spring.foto.pojo.Category;
import org.spring.foto.pojo.Photo;
import org.spring.foto.service.CategoryService;
import org.spring.foto.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/categories")
@CrossOrigin("*")
public class CategoriesApiController {
	
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	CategoryService categoryService;
	
	
//  Index categories
	@RequestMapping("/all") 
	public List<Category> getCategories() {
		
		return categoryService.findAll();
		
	}
	
//  Photo Categories
	@RequestMapping("/get/{id}") 
	public List<Category> getPhotoCategories(@PathVariable("id") int id) {
		
		Photo photo = photoService.findPhotoById(id).get();
		
		List<Category> cat = photo.getCategories();
		
		if (cat.isEmpty()) {
			return null;
		}

		return cat;
	}
}
