package org.spring.foto.api;

import java.util.List;

import org.spring.foto.pojo.Photo;
import org.spring.foto.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1")
@CrossOrigin("*")
public class ApiController {
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/photo/index")
	public List<Photo> getPhotos() {
		
		List<Photo> pht = photoService.findAll();
		
		for (Photo photo : pht) {
			if (!photo.isVisible()) {
				pht.remove(photo);
			}
		}
		return pht;
	}
}