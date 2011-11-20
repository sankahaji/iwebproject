package com.iwebproject.dao.impl;

import org.springframework.stereotype.Repository;

import com.iwebproject.bean.User;
import com.iwebproject.dao.UserDao;

@Repository
public class UserDaoImpl extends GenericDaoHibernateImpl<User, Long> implements UserDao {
	public UserDaoImpl() {
		super(User.class);
	}
}
