package com.learnings.spring.data;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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

    @Transactional
    public void noRollbackForCheckedException() throws SQLException {
        throw new SQLException();
    }

    @Transactional(rollbackOn = SQLException.class)
    public void rollbackForCheckedException() throws SQLException {
        throw new SQLException();
    }

    @Transactional()
    public void rollbackForUnCheckedException() {
        throw new RuntimeException();
    }

    @Transactional(dontRollbackOn = RuntimeException.class)
    public void noRollbackForUnCheckedException() {
        throw new RuntimeException();
    }
}
