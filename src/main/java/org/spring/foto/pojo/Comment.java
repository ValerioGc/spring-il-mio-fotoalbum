package org.spring.foto.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@NotNull(message = "Il contenuto del commento non può essere null")
	@NotEmpty(message = "Il contenuto del commento non può essere null")
	@Lob
	private String content;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="photo_id", nullable=true)
	private Photo photo;
	
	
	
	public Comment() { }
	public Comment(Photo photo, String content) {
		setPhoto(photo);
		setContent(content);
	}
	
	
	
//  Id	--------------------------------------
	public int getId() {
		return id;
	}


//  Content	--------------------------------------
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
//  Photo	--------------------------------------
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
	
	
	@Override
	public String toString() {
		return "Commento: " + getContent()
				+ "Foto associata: " + getPhoto();
	}
}
