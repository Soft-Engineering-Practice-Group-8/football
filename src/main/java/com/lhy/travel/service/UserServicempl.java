package com.lhy.travel.service;

import com.lhy.travel.dao.UserDao;
import com.lhy.travel.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServicempl implements UserService{

    @Autowired
    private UserDao userDao;



    @Override
    public User login(User user) {
        User userDB = userDao.findByUsername(user.getUsername());
        if (userDB != null) {
            if (userDB.getPwd().equals(user.getPwd())) {
                return userDB;
            }
            throw new RuntimeException("密码输入错误！");
        } else {
            throw new RuntimeException("用户名输入错误！");
        }
    }

}

