package com.project2.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.project2.hibernate.idgenerator.CustomGenerator;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
	@GenericGenerator(name = "book_seq",strategy = "com.project2.hibernate.idgenerator.CustomGenerator", parameters = {
				@Parameter(name = CustomGenerator.VALUE_PREFIX_PARAMETER, value = "B_"),
				@Parameter(name = CustomGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")}
		)
	@Column(name = "bookid", updatable = false, nullable = false)
	private String id;
	
	@Column(name = "title")
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}
}
