package com.exam.service;

import com.exam.entity.User;

public interface UserService {
    int testContoller();

    User queryByUserName(String username);
}
