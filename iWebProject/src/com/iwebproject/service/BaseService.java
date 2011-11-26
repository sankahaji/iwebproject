package com.iwebproject.service;

import javax.annotation.Resource;

import com.iwebproject.dao.AccountDao;

public class BaseService {
	@Resource
	protected AccountDao accountDao;
}
