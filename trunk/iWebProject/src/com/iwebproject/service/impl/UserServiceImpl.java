package com.iwebproject.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iwebproject.bean.User;
import com.iwebproject.service.BaseService;
import com.iwebproject.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseService implements UserService {

	@Override
	public void create(User user) {
		this.userDao.create(user);
	}

    @Override
    public User read(User user) {
        return this.userDao.read(user);
    }

}
