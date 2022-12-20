package org.spring.foto.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Table
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = true)
	@NotNull(message = "Il nome della categoria non deve essere vuoto")
	@NotEmpty(message = "Il nome della categoria non deve essere vuoto")
	private String name;
	
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
	private List<Photo> photos;

	
	public Category() { }
	public Category(String name) {
		setName(name);
	}
	public Category(String name, List<Photo> photos) {
		setName(name);
		setPhotos(photos);
	}

	
//  ID --------------------------------------
	public int getId() {
		return id;
	}
	
//  Name --------------------------------------
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

//  Photos --------------------------------------
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	
	@Override
	public String toString() {
		return "Nome categoria: " + getName()
				+ "Foto: " + getPhotos();
	}
}
