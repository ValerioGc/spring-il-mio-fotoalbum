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
	
// Find by Name or Tag
	public List<Photo> findByTitleOrTag(String q) {
		return photoRepo.findByTitleContainingOrTagContaining(q, q);
	}
	
//  Find photo relations
	@Transactional
	public List<Photo> findAllPhotoRelations() {
		
		List<Photo> photos = photoRepo.findAll();
		
		for (Photo photo : photos) {
			Hibernate.initialize(photo.getCategories());
			Hibernate.initialize(photo.getComments());
//			Hibernate.initialize(photo.getTags());
		}
		
		return photos;
	}
}
