package com.ct.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ct.domain.Forum;
import com.ct.domain.Person;
import com.ct.domain.Post;
import com.ct.util.HibernateUtil;


public class Test {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
//		Person author = new Person("author2", "a");  
//		Forum forum = new Forum("first forum ", "the very first", author); 
//		Post post = new Post("a post", author, forum); 
//		
//		session.save(author);
//		session.save(forum);
//		session.save(post);
		
//		Criteria criteria = session.createCriteria(Person.class);
//		criteria.add(Restrictions.eq("",10 ));
//		List<Person> list = criteria.list();
//		System.out.println(list.get(0));
		

		Criteria criteria = session.createCriteria(Forum.class);
		List<Forum> list = criteria.list();
		System.out.println(list);
		
		session.close();

	}
}
