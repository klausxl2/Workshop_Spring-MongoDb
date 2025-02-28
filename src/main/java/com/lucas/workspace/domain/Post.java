package com.lucas.workspace.domain;


import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lucas.workspace.dto.AuthorDto;

//NOME DA TABELA NO BANCO MONGO
@Document(collection= "Post")
public class Post {

	//GERANDO O ID
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDto AuthorDto;
	
	public Post() {
		
	}

	public Post(String id, Date date, String title, String body, AuthorDto AuthorDto) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.AuthorDto = AuthorDto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDto getAuthorDto() {
		return AuthorDto;
	}

	public void setAuthorDto(AuthorDto AuthorDto) {
		this.AuthorDto = AuthorDto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
