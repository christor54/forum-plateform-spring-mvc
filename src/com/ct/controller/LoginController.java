package com.ct.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ct.domain.Person;
import com.ct.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping (value="/login", method=RequestMethod.POST)
	public String handleLogin(HttpServletRequest req){
		System.out.println("In LoginController");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println("Username: "+ username);
		System.out.println("Password: "+ password);
		
		Person person = loginService.authenticate(username, password);
		
		if(person!=null)
			return "homepage";
		else{
			req.getSession().setAttribute("loginStatus", "login fail");
			req.getSession().setAttribute("username", username);
			
			return "login";
		}
		//In our applicationContext viewResolver is going to make the return as WEB-INF/pages/homepage.jsp
	}
	
	@RequestMapping(value="/gotToLoginPage", method=RequestMethod.GET)
	public String goToLoginn(){
		return "login"; 
	}
	

}
