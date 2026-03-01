package com.learnings.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserData() {
        return userDao.getUsers().getFirst();
    }

    public int getUsersCount() {
        return userDao.getCount();
    }
}
