package com.iwebproject.service;

import javax.annotation.Resource;

import com.iwebproject.dao.UserDao;

public class BaseService {
	@Resource
	protected UserDao userDao;
}
