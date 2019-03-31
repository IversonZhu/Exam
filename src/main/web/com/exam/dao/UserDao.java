package com.exam.dao;

import com.exam.entity.User;

public interface UserDao {
    int selectCount();

    User selectByUsername(String username);
}
