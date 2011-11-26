package com.iwebproject.service;

import com.iwebproject.bean.Account;

public interface AccountService {
    void create(Account user);
    
    Account read(Account user);
}
