package com.ct.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post {
	@Id
	@SequenceGenerator(name = "seqPost", sequenceName = "sequence_post")
	@GeneratedValue(generator = "seqPost", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column
	private String content;

	@Temporal(TemporalType.DATE)
	@Column
	private Date dateCreated;

	@ManyToOne
	private Person author;

	@ManyToOne
	private Forum forum;

	public Post() {
		super();
		this.dateCreated = new Date(); 
	}

	public Post(String content, Person author) {
		super();
		this.content = content;
		this.author = author;
		this.dateCreated = new Date(); 
	}

	public Post(String content ,Person author,
			Forum forum) {
		super();
		this.content = content;
		this.author = author;
		this.forum = forum;
		this.dateCreated = new Date(); 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

}
