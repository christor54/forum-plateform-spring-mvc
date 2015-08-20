package com.ct.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Person {
	@Id
	@SequenceGenerator(name="seqPerson", sequenceName="sequence_person")
	@GeneratedValue(generator = "seqPerson", strategy=GenerationType.SEQUENCE)
	private int id; 
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@OneToMany(mappedBy="author")
	List<Forum> forums; 
	
	@OneToMany(mappedBy="author")
	List<Post> posts; 

	public Person() {
		super();
	}
	
	public Person( String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", password="
				+ password + ", forums=" + forums + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Forum> getForums() {
		return forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}
	
}
