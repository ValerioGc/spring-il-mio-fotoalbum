package org.spring.foto.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.spring.foto.pojo.Category;
import org.spring.foto.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
//  Save
	public void save(Category categories) {
		categoryRepo.save(categories);
	}
		
//  Find
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}
	
//  Find by ID
	public Category findCategoryById(int id) {
		return categoryRepo.findById(id).get();
	}
	
//  Delete by ID
	public void deleteCategoryById(int id) {
		categoryRepo.deleteById(id);
	}
	
//  Find Photos
	@Transactional
	public List<Category> findAllCategoryPhotos() {
		
		List<Category> categories = categoryRepo.findAll();
		
		for (Category cat : categories) {
			Hibernate.initialize(cat.getPhotos());
		}
		
		return categories;
	}
}
