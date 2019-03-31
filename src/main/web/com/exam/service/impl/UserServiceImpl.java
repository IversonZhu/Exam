package com.exam.service.impl;

import com.exam.dao.UserDao;
import com.exam.entity.User;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public int testContoller() {
        int i = userDao.selectCount();
        return i;
    }

    @Override
    public User queryByUserName(String username) {
        return userDao.selectByUsername(username);
    }
}
