package com.learning.rest.webservices.restful_web_services.dao;

import com.learning.rest.webservices.restful_web_services.UsersSpringDataJPA.UsersDataJPA;
import com.learning.rest.webservices.restful_web_services.controllers.UserNotFoundException;
import com.learning.rest.webservices.restful_web_services.controllers.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoService {
    @Autowired
    UsersDataJPA usersDataJPA;

//    static List<Users> usersList = new ArrayList<>();
//
//    static {
//        usersList.add(new Users(1, "Prajwal", LocalDate.now().minusYears(25)));
//    }

    public List<Users> getAllUsers() {
        return usersDataJPA.findAll();
    }

    public Users save(Users user) {
        usersDataJPA.save(user);
        return user;
    }

    public Users findOne(int id) {
        return usersDataJPA.findById(id).orElse(null);
    }

//    public void deleteUser(int id) {
//        Users user = findOne(id);
//        if(user == null) {
//            throw new UserNotFoundException("User not found with id: " + id);
//        } else {
//            usersList.remove(user);
//        }
//
//    }
}
