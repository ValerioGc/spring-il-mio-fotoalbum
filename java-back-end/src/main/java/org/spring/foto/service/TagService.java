package org.spring.foto.service;

import java.util.List;


import org.spring.foto.pojo.Tag;
import org.spring.foto.repo.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TagService {

	@Autowired
	private TagRepo tagRepo;
	
// Save
	public void save(Tag tags) {
		tagRepo.save(tags);
	}
		
// Find
	public List<Tag> findAll() {
		return tagRepo.findAll();
	}
	
// Find by ID
	public Tag findTagById(int id) {
		return tagRepo.findById(id).get();
	}
	
// Delete by ID
	public void deleteTagById(int id) {
		tagRepo.deleteById(id);
	}
}
