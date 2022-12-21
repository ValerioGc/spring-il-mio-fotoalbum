package org.spring.foto.api;

import java.util.List;
import java.util.Set;

import org.spring.foto.pojo.Category;
import org.spring.foto.pojo.Comment;
import org.spring.foto.pojo.Photo;
import org.spring.foto.service.CategoryService;
import org.spring.foto.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/comments")
@CrossOrigin("*")
public class CommentsApiController {
	
	
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
	public Set<Comment> getPhotoCategories(@PathVariable("id") int id) {
		
		Photo photo = photoService.findPhotoById(id).get();
		
		Set<Comment> com = photo.getComments();
		
		if (com.isEmpty()) {
			return null;
		}

		return com;
	}
}
