package com.iwebproject.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iwebproject.bean.Account;
import com.iwebproject.service.AccountService;
import com.iwebproject.service.BaseService;

@Service
@Transactional
public class AccountServiceImpl extends BaseService implements AccountService {

	@Override
	public void create(Account account) {
		this.accountDao.create(account);
	}

    @Override
    public Account read(Account account) {
        return this.accountDao.read(account);
    }

}
