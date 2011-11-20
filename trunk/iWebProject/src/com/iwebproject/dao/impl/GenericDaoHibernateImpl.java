package com.iwebproject.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.iwebproject.dao.GenericDao;

public class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	@Resource
	private SessionFactory sessionFactory;

	private Class<T> type;

	public GenericDaoHibernateImpl(Class<T> type) {
		super();
		this.type = type;
	}
	
	@Override
	public void create(T newInstance) {
		this.getCurrentSession().save(newInstance);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T read(PK id) {
		return (T)this.getCurrentSession().get(type, id);
	}

	@Override
	public void update(T transientObject) {
		this.getCurrentSession().update(transientObject);
	}

	@Override
	public void delete(T persistentObject) {
		this.getCurrentSession().delete(persistentObject);
	}
	
	protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
