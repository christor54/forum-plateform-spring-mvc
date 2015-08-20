package com.ct.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ct.domain.Person;
import com.ct.util.HibernateUtil;

public class Dao {

	public void save(Object object) {
		Session session = HibernateUtil.getSession(); 
		Transaction tx = session.beginTransaction();
		
		session.save(object); 
		
		tx.commit();
		session.close();
		
	}
	
	public Person getPersonByUsername(String username){
		Session session = HibernateUtil.getSession(); 
		
		Criteria criteria = session.createCriteria(Person.class);
		criteria.add(Restrictions.eq("username", username));
		List<Person> persons = criteria.list(); 
		Person person = null; 
		if(persons!=null)
			person = persons.get(0);
		return person;
		
		
	}
}
