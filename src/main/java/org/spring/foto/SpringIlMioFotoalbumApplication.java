package org.spring.foto;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.spring.foto.pojo.Role;
import org.spring.foto.pojo.User;
import org.spring.foto.pojo.Category;
import org.spring.foto.pojo.Photo;
import org.spring.foto.pojo.Tag;
import org.spring.foto.service.CategoryService;
import org.spring.foto.service.PhotoService;
import org.spring.foto.service.TagService;
import org.spring.foto.service.UserService;
import org.spring.foto.service.RoleService;
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
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category("Monumenti");
		Category c2 = new Category("Paesaggi");
		Category c3 = new Category("Ritratti");
		
		List<Category> categoryL1 = new ArrayList<>(); 
		categoryL1.add(c1);
		categoryL1.add(c2);
		categoryL1.add(c3);
		
		List<Category> categoryL2 = new ArrayList<>(); 
		categoryL1.add(c1);
		categoryL1.add(c3);
		
		
		
		categoryService.save(c1);
		categoryService.save(c2);
		categoryService.save(c3);
		
		Photo p1 = new Photo("foto-1", "description-1", "test-Url-1", false, "city");
		Photo p2 = new Photo("foto-2", "description-2", "test-Url-2", true, categoryL1);
		Photo p3 = new Photo("foto-3", "description-3", "test-Url-3", true, "landscape");
		Photo p4 = new Photo("foto-4", "description-4", "test-Url-4", false, categoryL2, "nature");
		Photo p8 = new Photo("foto-8", "description-4", "test-Url-8", true, categoryL1, "sea");
		
		List<Photo> photosL1 = new ArrayList<>(); 
		photosL1.add(p1);
		photosL1.add(p2);
		photosL1.add(p3); 

		photoService.save(p1);
		photoService.save(p2);
		photoService.save(p3);
		photoService.save(p4);
		photoService.save(p8);
		
//		System.out.println(p1);
//		System.out.println(p2);
		
		
		Category c4 = new Category("categoria-3", photosL1);
		
		categoryService.save(c4);
		
//		System.out.println(c1);
//		System.out.println(c2);
//		System.out.println(c3);

	//  Tags
//		Tag t1 = new Tag("landscape");
//		Tag t2 = new Tag("nature");
//		Tag t3 = new Tag("mountains",  photosL1);
		
//		tagService.save(t1);
//		tagService.save(t2);
////		tagService.save(t3);
//
//		System.out.println(t1);
//		System.out.println(t2);
////		System.out.println(t3);
//		
//		Set<Tag> tagsL1 = new HashSet<>(); 
//		tagsL1.add(t1);
//		tagsL1.add(t2);
//		tagsL1.add(t3);
		
		Photo p5 = new Photo("foto-5", "description-5", "test-Url-5", true, categoryL1, "sea");
		Photo p6 = new Photo("foto-6", "description-5", "test-Url-6", true, categoryL1, "mountain");
		Photo p7 = new Photo("foto-7", "description-5", "test-Url-7", true, categoryL1, "nature");
		
		photoService.save(p5);
		photoService.save(p6);
		photoService.save(p7);
		
		
//		System.out.println(p5);
		
	//  Users and roles
		
		Role admin = new Role("ADMIN");
		Role user = new Role("USER");

		roleService.save(admin);
		roleService.save(user);
		
		Set<Role> userAdmin = new HashSet<>();		
		userAdmin.add(user);
		userAdmin.add(admin);

		User userUser = new User("user", "{noop}pwd", user);
		User adminUser = new User("admin", "{noop}pwd2", admin);
		User usAd = new User("userAdmin", "{noop}pwd3", userAdmin);
	
		userService.save(userUser);
		userService.save(adminUser);
		userService.save(usAd);
		
		System.out.println(userUser);
		System.out.println(adminUser);
		System.out.println(usAd);
	}
}
