package com.tensquare.user.service;

import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.PortUnreachableException;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User SelectById(String userId) {
        return userDao.selectById(userId);
    }
}
