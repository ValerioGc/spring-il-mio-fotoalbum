package org.spring.foto.api;

import java.util.List;
import java.util.Set;

import org.pizzeria.crud.pojo.Pizza;
import org.spring.foto.pojo.Category;
import org.spring.foto.pojo.Comment;
import org.spring.foto.pojo.Photo;
import org.spring.foto.service.CategoryService;
import org.spring.foto.service.CommentService;
import org.spring.foto.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/1/comments")
@CrossOrigin("*")
public class CommentsApiController {
	
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	CommentService commentService; 
	
	
//  Index categories
	@RequestMapping("/all") 
	public List<Comment> getComment() {
		
		return commentService.findAll();
		
	}
	
//  Photo Categories
	@RequestMapping("/get/{id}") 
	public Set<Comment> getPhotoComments(@PathVariable("id") int id) {
		
		Photo photo = photoService.findPhotoById(id).get();
		
		Set<Comment> com = photo.getComments();
		
		if (com.isEmpty()) {
			return null;
		}

		return com;
	}
	
//  New comment
	@PostMapping("/store/{id}") 
	public Comment storeComment(@PathVariable("id") int id, 
								@Valid @RequestBody 
								Comment comment) {
		
		Photo pht = photoService.findPhotoById(id).get();
		
		Comment newCom = new Comment(pht, comment.getContent());
		
		commentService.save(newCom);
		
		return newCom;
	}
}
