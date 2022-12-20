package org.spring.foto;


import java.util.ArrayList;
import java.util.List;

import org.spring.foto.pojo.Category;
import org.spring.foto.pojo.Photo;
import org.spring.foto.service.CategoryService;
import org.spring.foto.service.PhotoService;
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

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category();
		Category c2 = new Category("TestNome");
		Category c3 = new Category("TestNome");
		
		List<Category> categoryL1 = new ArrayList<>(); 
		categoryL1.add(c1);
		categoryL1.add(c3);
		
		
		Photo p1 = new Photo();
		Photo p2 = new Photo("TestNome", "description", "testUrl", true);
		Photo p3 = new Photo("TestNome", "description", "testUrl", true, categoryL1);
		
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	
		categoryService.save(c1);
		categoryService.save(c2);
		categoryService.save(c3);
		
		photoService.save(p1);
		photoService.save(p2);
		photoService.save(p3);
	}
	
	
}
