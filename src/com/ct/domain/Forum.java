package com.ct.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Forum {
	@Id
	@SequenceGenerator(name = "seqForum", sequenceName = "sequence_forum")
	@GeneratedValue(generator = "seqForum", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private Date dateCreated;

	@ManyToOne
	private Person author;

	@OneToMany(mappedBy = "forum")
	private List<Post> posts;

	public Forum() {
		super();
	}

	public Forum(String title, String description, Person author) {
		super();
		this.title = title;
		this.description = description;
		this.author = author;
	}

	public Forum(String title, String description, Person author,
			List<Post> posts) {
		super();
		this.title = title;
		this.description = description;
		this.author = author;
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Forum [id=" + id + ", title=" + title + ", description="
				+ description + ", dateCreated=" + dateCreated + ", author="
				+ author + ", posts=" + posts + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
