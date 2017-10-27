package com.xxyjsjgcxy.suser.dao.impl;

import org.hibernate.SessionFactory;

import com.xxyjsjgcxy.suser.dao.SuserDao;

public class SuserDaoImpl implements SuserDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/*
	 * 
	 */
}
