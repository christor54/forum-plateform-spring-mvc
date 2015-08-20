package com.ct.service;

import org.springframework.stereotype.Component;

import com.ct.domain.Person;

@Component
public class LoginService {

	public Person authenticate(String username, String password){
		if(username.equals("a")&& password.equals("a")){
			return new Person(username,password);
		}
		return null; 
	}
}
