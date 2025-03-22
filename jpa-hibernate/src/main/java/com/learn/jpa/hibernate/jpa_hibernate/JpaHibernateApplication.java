package com.learn.jpa.hibernate.jpa_hibernate;

import com.learn.jpa.hibernate.jpa_hibernate.jdbc.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaHibernateApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpaHibernateApplication.class, args);
	}


}
