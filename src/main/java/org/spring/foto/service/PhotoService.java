package org.spring.foto.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.spring.foto.pojo.Photo;
import org.spring.foto.repo.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepo photoRepo;
	
// Save
	public Photo save(Photo photo) {
		return photoRepo.save(photo);
	}
		
// Find
	public List<Photo> findAll() {
		return photoRepo.findAll();
	}
	
// Find by ID
	public Optional<Photo> findPhotoById(int id) {
		return photoRepo.findById(id);
	}
	
// Delete Pizza
	public void deletePhoto(Photo photo) {
		photoRepo.delete(photo);
	}
// Delete by ID
	public void deletePhotoById(int id) {
		photoRepo.deleteById(id);
	}
	
// Find by name
	public List<Photo> findByTitle(String title) {
		return photoRepo.findByTitleContainingIgnoreCase(title);
	}
	
//  Find Categories
	@Transactional
	public List<Photo> findAllPhotoCategory() {
		
		List<Photo> photos = photoRepo.findAll();
		
		for (Photo photo : photos) {
			Hibernate.initialize(photo.getCategories());
		}
		
		return photos;
	}
	
// 	Find Tags
	@Transactional
	public List<Photo> findAllPhotosTags() {
		
		List<Photo> photos = photoRepo.findAll();
		
		for (Photo photo : photos) {
			Hibernate.initialize(photo.getTags());
		}
		
		return photos;
	}
}
