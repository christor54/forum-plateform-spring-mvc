package com.ct.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ct.domain.Forum;
import com.ct.domain.Person;
import com.ct.domain.Post;
import com.ct.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Person author = new Person("author", "a");  
		Forum forum = new Forum("first forum", "the very first", author); 
		Post post = new Post("a post", author, forum); 
		
		session.save(author);
		session.save(forum);
		session.save(post);
		
		tx.commit();
		session.close();
	}
}
