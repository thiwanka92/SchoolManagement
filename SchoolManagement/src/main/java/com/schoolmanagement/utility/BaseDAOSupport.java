package com.schoolmanagement.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDAOSupport {
	
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Object entity) {
		getSession().persist(entity);
	}

	public void delete(Object entity) {	
		getSession().delete(entity);
	}
	
	public void update(Object entity) {	
		getSession().update(entity);
	}
}
