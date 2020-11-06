package com.bk.dao;

import com.bk.po.Type;
import com.bk.po.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

    //    findByUsernameAndPassword
    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
