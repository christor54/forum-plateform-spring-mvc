package com.ct.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private HibernateUtil() {
	}

	private static SessionFactory sessionFactory;

	private static final String path = "com/ct/resources/hibernate.cfg.xml";

	public static Session getSession() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure(path)
					.buildSessionFactory();
		}
		return sessionFactory.openSession();
	}
}
