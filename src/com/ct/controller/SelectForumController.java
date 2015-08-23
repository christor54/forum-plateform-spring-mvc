package com.ct.controller;

import java.io.IOException;
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
import com.ct.service.ForumService;

@Controller
public class SelectForumController {

	@Autowired
	ForumService forumService;

	@RequestMapping(value = "/addForum", method = RequestMethod.POST)
	public String goToForum(HttpServletResponse response,
			HttpServletRequest request, @Valid Forum forum,
			BindingResult bindingResult) {
		System.out.println("In SelectForumController");

		if (bindingResult.hasErrors()) {
			System.out.println("Found validation errors");
		}
		
		forumService.saveForum(forum);
		
		try {
			response.sendRedirect(request.getContextPath() +"/goToHomepage");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ""; 
	}

	@RequestMapping(value = "/goToForumPage", method = RequestMethod.GET)
	public String goToLoginPage(ModelMap modelMap, HttpServletRequest req,
			int forumId) {
		System.out.println("In SelectForumController, goToLoginPage");
		List<Forum> forums = (List<Forum>) req.getSession().getAttribute("forums");
		Forum forumSelected = getForumSelected(forumId, forums);
		req.getSession().setAttribute("forum", forumSelected);

		return "forum";
	}

	@RequestMapping(value = "/goToHomepage", method = RequestMethod.GET)
	public String goToHomepage(HttpServletRequest req, ModelMap modelMap) {
		modelMap.addAttribute("forum", new Forum());
		insertIntoSessionForums(req);
		return "homepage";
	}

	private Forum getForumSelected(int forumId, List<Forum> forums) {
		if (forums == null) {
			return null;
		} else {
			Forum forumSelected = null;
			for (Forum forum : forums) {
				if (forum.getId() == forumId) {
					forumSelected = forum;
				}
			}
			return forumSelected;
		}
	}
	
	private void insertIntoSessionForums(HttpServletRequest req){
//		List<Forum> forums = new ArrayList();
//		Forum forum1 = new Forum("first forum", "the very first"); 
//		Forum forum2 = new Forum("second forum", "the very second"); 
//		forums.add(forum1);
//		forums.add(forum2);

		List<Forum> forums = forumService.getForums();
		req.getSession().setAttribute("forums", forums);
	}

}
