package com.ct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ct.dao.ForumDao;
import com.ct.domain.Forum;

@Component
public class ForumService {
	
	@Autowired
	private ForumDao forumDao;

	public Forum getForumById (int id)  {
		return forumDao.getForumById(id);
	}

	public List<Forum> getForums (){
		return forumDao.getForums(); 
	}
	
	public void saveForum(Forum forum){
		forumDao.saveForum(forum);;
	}

	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}
	
	
}
