package com.iwebproject.service;

import com.iwebproject.bean.User;

public interface UserService {
    void create(User user);
    
    User read(User user);
}
