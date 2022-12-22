package org.spring.foto.service;

import java.util.List;
import java.util.Optional;

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
	public Optional<Category> findCategoryById(int id) {
		return categoryRepo.findById(id);
	}
	
//  Delete
	public void deleteCategory(Category category) {
		categoryRepo.delete(category);
	}

//  Delete by ID
	public void deleteCategoryById(int id) {
		categoryRepo.deleteById(id);
	}
	
//  Find Category's photo
	@Transactional
	public List<Category> findAllCategoryPhotos() {
		
		List<Category> categories = categoryRepo.findAll();
		
		for (Category cat : categories) {
			Hibernate.initialize(cat.getPhotos());
		}
		
		return categories;
	}
}
