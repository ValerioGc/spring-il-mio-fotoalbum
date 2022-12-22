package org.spring.foto.pojo;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	@NotEmpty(message = "Il nome della foto non deve essere vuoto")
	private String title;
	
	
	@Column(nullable = true)
	@Lob
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
	
	
	@OneToMany(mappedBy = "photo", cascade = CascadeType.REMOVE)
	private Set<Comment> comments; 
	
	
//	@ManyToMany
//	@JsonIgnore
//	private Set<Tag> tags;
	private String tag;
	
	
	public Photo() { }
	public Photo(String title, String description, String url, boolean visible) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
	}
// 	Test comment
	public Photo(String title, String description, String url, boolean visible, Set<Comment> comments) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		setComments(comments);
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

//  With category
	public Photo(String title, String description, String url, 
					boolean visible, Category category) {
		
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		addCategory(category);
	}

//  With tag
	public Photo(String title, String description, String url, 
			boolean visible, String tag) {
		
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		setCategories(categories);
		setTag(tag);
	}
//  With Categories and tag
	public Photo(String title, String description, String url, 
			boolean visible, List<Category> categories, String tag) {

		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		setCategories(categories);
		setTag(tag);
	}
	
	
//  Id	--------------------------------------
	public int getId() {
		return id;
	}

	
//  Title --------------------------------------
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
//  Description --------------------------------------
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
//  Url --------------------------------------
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
//  Visibility --------------------------------------
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) { 
		this.visible = visible;
	}

	
//  Tag
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
// ------------------ Relations ------------------ // 
//  Categories 
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public void addCategory(Category category) {
		
		boolean finded = false;
		
		for (Category c : getCategories()) {
			
			if (c.getId() == category.getId()) {
				finded = true;				
			}

		}
		
		if(!finded) {
			getCategories().add(category);			
		}
	}
	public void removeCategory(Category category) {
		getCategories().remove(category);
	}

//  Comments
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

//  Tags
//	public Set<Tag> getTags() {
//		return tags;
//	}
//	public void setTags(Set<Tag> tags) {
//		this.tags = tags;
//	}
	
// ------------------------------------------------- //

	
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