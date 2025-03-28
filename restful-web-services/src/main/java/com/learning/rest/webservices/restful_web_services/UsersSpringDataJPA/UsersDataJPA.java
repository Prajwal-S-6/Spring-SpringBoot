package com.learning.rest.webservices.restful_web_services.UsersSpringDataJPA;

import com.learning.rest.webservices.restful_web_services.controllers.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDataJPA extends JpaRepository<Users, Integer> {
}
