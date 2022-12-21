package org.spring.foto.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.spring.foto.pojo.Comment;
import org.spring.foto.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CommentService {

	@Autowired
	private CommentRepo commentRepo;
	
// Save
	public void save(Comment comment) {
		commentRepo.save(comment);
	}
		
// Find all
	public List<Comment> findAll() {
		return commentRepo.findAll();
	}
	
// Find by ID
	public Comment findCommentById(int id) {
		return commentRepo.findById(id).get();
	}
	
// Delete by ID
	public void deleteCommentById(int id) {
		commentRepo.deleteById(id);
	}
	
// Find Photos
	@Transactional
	public List<Comment> findAllPhotos() {
		
		List<Comment> comments = commentRepo.findAll();
		
		for (Comment com : comments) {
			Hibernate.initialize(com.getPhoto());
		}
		
		return comments;
	}
}
