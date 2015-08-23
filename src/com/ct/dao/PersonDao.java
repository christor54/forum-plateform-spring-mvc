package com.ct.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ct.domain.Person;

@Component
public class PersonDao {
	
	@Autowired
	private Dao dao; 
	
	public void savePerson (Person person){
		dao.saveObject(person);
	}
	
	public Person getPersonByUsername(String username){
		return (Person) dao.getObjectByField(Person.class, "username", username);
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	
}
