package com.ct.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ct.domain.Forum;
import com.ct.domain.Person;
import com.ct.service.ForumService;
import com.ct.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@Autowired
	ForumService forumService;
	
	@RequestMapping (value="/tryToLogin", method=RequestMethod.POST)
//	@RequestMapping (value="/login", method=RequestMethod.POST)
	public String handleLogin(HttpServletRequest req, HttpServletResponse res, @Valid Person person, BindingResult bindingResult){
		System.out.println("In LoginController");
		
		if(bindingResult.hasErrors()){
			System.out.println("Found validation errors");
		}
		
		Person personAuthenticated = loginService.authenticate(person.getUsername(),person.getPassword());
		
		if(personAuthenticated!=null){
			req.getSession().setAttribute("person", personAuthenticated);
			
			try {
				res.sendRedirect(req.getContextPath() +"/goToHomepage");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ""; 
			//In our applicationContext viewResolver is going to make the return as WEB-INF/pages/homepage.jsp
		}
		else{
			return "login";
		}
		
	}
	
	@RequestMapping(value="/goToLoginPage", method=RequestMethod.GET)
	public String goToLoginPage(ModelMap modelMap){
		modelMap.addAttribute("person", new Person());
		
		return "login"; 
	}
	

	

}
