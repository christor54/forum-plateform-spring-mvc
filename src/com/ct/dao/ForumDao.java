package com.ct.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ct.domain.Forum;

@Component
public class ForumDao {

	
	@Autowired
	private Dao dao; 

	
	
	public ForumDao() {
		super();
	}

	@Transactional
	public Forum getForumById(int id) {
		return (Forum) dao.getObjectByField(Forum.class, "id", new Integer(id));
	}

	@Transactional
	public List<Forum> getForums() {
		return (List<Forum>) dao.getObjectsByClass(Forum.class);
	}
	
	@Transactional
	public void saveForum(Forum forum) {
		 dao.saveObject(forum);
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	

}
