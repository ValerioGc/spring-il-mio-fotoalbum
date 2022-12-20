package org.spring.foto.pojo;

import java.util.List;
import java.util.Set;

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
	

	
	@ManyToMany
	@JsonIgnore
	private List<Category> categories; 
	
	@ManyToMany
	@JsonIgnore
	private Set<Tag> tags; 
	
	public Photo() { }
	public Photo(String title, String description, String url, boolean visible) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
	}
//  With categories
	public Photo(String title, String description, String url, 
					boolean visible, List<Category> categories) {
		
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		setCategories(categories);
	}
//  With tags
	public Photo(String title, String description, String url, 
			boolean visible, Set<Tag> tags) {
		
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		setCategories(categories);
	}
//  With Categories and tags
	public Photo(String title, String description, String url, 
			boolean visible, List<Category> categories, Set<Tag> tags) {

		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		setTags(tags);
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
	
//  Visibility
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	// ------------------ Relations ------------------ // 

//  Categories
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

//  Tags
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	
	@Override
	public String toString() {
		return "\nNome foto: " + getTitle()
				+ "\nId: " + getId()
				+ "\nVisibile: " + isVisible()
				+ "\nDescrizione: " + getDescription()
				+ "\nUrl: " + getUrl()
				+ "\n---------------------------------------";
	}
}
