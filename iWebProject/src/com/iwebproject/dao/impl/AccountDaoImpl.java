package com.iwebproject.dao.impl;

import org.springframework.stereotype.Repository;

import com.iwebproject.bean.Account;
import com.iwebproject.dao.AccountDao;

@Repository
public class AccountDaoImpl extends GenericDaoHibernateImpl<Account, Long> implements AccountDao {
	public AccountDaoImpl() {
		super(Account.class);
	}
}
