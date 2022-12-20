package org.spring.foto.pojo;

import java.util.List;

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
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false )
	@NotNull(message = "Il nome della foto non deve essere vuoto")
	@NotEmpty(message = "Il nome della foto non deve essere vuoto")
	private String title;
	
	@Column(nullable = true)
	private String description;
	
	
	@Column(unique = true, nullable = false )
	@NotNull(message = "L'url della foto non deve essere vuoto")
	@NotEmpty(message = "L'url della foto non deve essere vuoto")
	private String url;
	
		
	@Column(nullable = false )
	@NotNull(message = "Il nome dell'ingrediente non deve essere vuoto")
	private boolean visible;
	
	
	private String tag;
	
	@ManyToMany
	private List<Category> categories; 
	
	public Photo() { }
	public Photo(String title, String description, String url, boolean visible) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
	}
	public Photo(String title, String description, String url, 
					boolean visible, List<Category> categories) {
		
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		setCategories(categories);
	}
	
	
//  Id	
	public int getId() {
		return id;
	}

//  Title	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
//  Description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
//  Url 
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
//  Tags
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
//  Visibility
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
//  Categories
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	

	@Override
	public String toString() {
		return "Nome foto: " + getTitle()
				+ "Id: " + getId()
				+ "Url: " + getUrl();
	}
}
