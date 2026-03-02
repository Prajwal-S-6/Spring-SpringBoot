package com.learnings.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDaoJpa userDaoJpa;

    public Users getUserData() {
        return userDao.getUsers().getFirst();
    }

    public int getUsersCount() {
        return userDao.getCount();
    }

    public List<Users> getAllUsers() {
        return userDaoJpa.findAll();
    }
}
