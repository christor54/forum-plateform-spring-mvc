package com.ct.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ct.domain.Person;

public class Dao {

	private SessionFactory sessionFactory;

	public Dao() {
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveObject(Object object) {
		Session session = sessionFactory.getCurrentSession();
		session.save(object);
	}

	@Transactional
	public List getObjectsByField(Class myClass, String field, String value) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(myClass);
		criteria.add(Restrictions.eq(field, value));
		List list = criteria.list();
		return list;
	}

	@Transactional
	public List getObjectsByClass(Class myClass) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(myClass);
		List list = criteria.list();
		return list;
	}

	@Transactional
	public Object getObjectByField(Class myClass, String field, Object value) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(myClass);
		criteria.add(Restrictions.eq(field, value));
		List list = criteria.list();
		if (list == null)
			return null;
		else
			return list.get(0);
	}

	@Transactional
	public List getObjectsByCriterion(Class myClass, Criterion criterion) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(myClass);
		criteria.add(criterion);
		List list = criteria.list();
		return list;
	}

}
