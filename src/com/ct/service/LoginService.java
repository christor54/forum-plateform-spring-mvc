package com.ct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ct.dao.PersonDao;
import com.ct.domain.Person;

@Component
public class LoginService {

	@Autowired
	private PersonDao dao; 
	
	public Person authenticate(String username, String password){
		
		Person person = dao.getPersonByUsername(username);
		if(person!=null&&username.equals("a")&& password.equals("a")){
			return person;
		}
		return null; 
	}
}
