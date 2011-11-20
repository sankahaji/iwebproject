package com.iwebproject.dao.impl;

import com.iwebproject.bean.User;
import com.iwebproject.dao.UserDao;

public class UserDaoImpl extends GenericDaoHibernateImpl<User, Long> implements UserDao {
	public UserDaoImpl() {
		super(User.class);
	}
}
