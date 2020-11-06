package com.bk.service;

import com.bk.dao.UserRepository;
import com.bk.po.Tag;
import com.bk.po.Type;
import com.bk.po.User;
import com.bk.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

    @Override
    public User getUserByName(String username) {
        return userRepository.findByUsername(username);
    }
}
