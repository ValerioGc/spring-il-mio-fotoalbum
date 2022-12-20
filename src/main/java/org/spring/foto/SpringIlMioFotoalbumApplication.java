package org.spring.foto;


import java.util.ArrayList;
import java.util.List;

import org.spring.foto.pojo.Category;
import org.spring.foto.pojo.Photo;
import org.spring.foto.pojo.Tag;
import org.spring.foto.service.CategoryService;
import org.spring.foto.service.PhotoService;
import org.spring.foto.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {
	
	@Autowired
	private PhotoService photoService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TagService tagService;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category("TestNome1");
		Category c2 = new Category("TestNome2");
		
		List<Category> categoryL1 = new ArrayList<>(); 
		categoryL1.add(c1);
		categoryL1.add(c2);
		
		categoryService.save(c1);
		categoryService.save(c2);
		
		Photo p1 = new Photo("TestNome1", "description1", "test-Url1", true);
		Photo p2 = new Photo("TestNome2", "description2", "test-Url2", true, categoryL1);
		Photo p4 = new Photo("TestNome4", "description4", "test-Url4", false);
		
		List<Photo> photosL1 = new ArrayList<>(); 
		photosL1.add(p1);
		photosL1.add(p2);
		photosL1.add(p4);

		photoService.save(p1);
		photoService.save(p2);
		
		System.out.println(p1);
		System.out.println(p2);
		
		
		Category c3 = new Category("TestNome3-category", photosL1);
		
		categoryService.save(c3);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

		Tag t1 = new Tag("landscape");
		Tag t2 = new Tag("nature");
		Tag t3 = new Tag("mountains",  photosL1);
		
		tagService.save(t1);
		tagService.save(t2);
		tagService.save(t3);

		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
	}
	
	
}
