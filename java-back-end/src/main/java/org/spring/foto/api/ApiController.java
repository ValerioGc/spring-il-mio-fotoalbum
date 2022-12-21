package org.spring.foto.api;

import java.util.List;

import org.spring.foto.pojo.Category;
import org.spring.foto.pojo.Photo;
import org.spring.foto.service.CategoryService;
import org.spring.foto.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/photo")
@CrossOrigin("*")
public class ApiController {
	
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/index")
	public List<Photo> getPhotos() {
		
		List<Photo> photoList = photoService.findAll();
		
		for (Photo photo : photoList) {
			
			if (!photo.isVisible()) {
				
//				photoList.remove(photo);
			
			}
		}

		return photoList;
	}
//  Photo Categories
	@RequestMapping("/get/{id}") 
	public List<Photo> getCategoriesPhoto(@PathVariable("id") int id) {
		
		Category cat = categoryService.findCategoryById(id);
		
		List<Photo> photo = cat.getPhotos();
		
		if (photo.isEmpty()) {
			return null;
		}

		return photo;
	}
}