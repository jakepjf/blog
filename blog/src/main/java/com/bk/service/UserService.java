package com.bk.service;

import com.bk.po.Type;
import com.bk.po.User;

public interface UserService {

    User checkUser(String username, String password);

    User getUserByName(String username);
}
