package com.learn.jpa.hibernate.jpa_hibernate;

import com.learn.jpa.hibernate.jpa_hibernate.course.Course;
import com.learn.jpa.hibernate.jpa_hibernate.jdbc.CourseJdbcRepository;
import com.learn.jpa.hibernate.jpa_hibernate.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseJpaRepository jpaRepository;

    @Override
    public void run(String... args) throws Exception {

        // this is for spring jdbc
//        repository.insert(new Course(1, "Learn Azure", "Udemy"));
//        repository.insert(new Course(2, "Learn GCP", "Udemy"));
//        repository.insert(new Course(3, "Learn AWS", "Udemy"));
//
//        repository.delete(3);
//
//        System.out.println(repository.select(2));

        jpaRepository.insert(new Course(1, "Learn Azure JPA", "Udemy"));
        jpaRepository.insert(new Course(2, "Learn GCP JPA", "Udemy"));
        jpaRepository.insert(new Course(3, "Learn AWS JPA", "Udemy"));

        // this will update since id=1 is already is present
        jpaRepository.insert(new Course(1, "Learn Azure JPA", "Coursera"));

        jpaRepository.delete(3);

        System.out.println(jpaRepository.select(2));

    }
}
