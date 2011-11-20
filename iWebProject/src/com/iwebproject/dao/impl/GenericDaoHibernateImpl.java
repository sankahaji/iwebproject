package com.iwebproject.dao.impl;

import java.io.Serializable;

import com.iwebproject.dao.GenericDao;

public class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	@Override
	public PK create(T newInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T read(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T transientObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T persistentObject) {
		// TODO Auto-generated method stub
		
	}

}
