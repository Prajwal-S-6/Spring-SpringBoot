package com.learn.jpa.hibernate.jpa_hibernate.jdbc;

import com.learn.jpa.hibernate.jpa_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;


    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn Azure", "Udemy"));
        repository.insert(new Course(2, "Learn GCP", "Udemy"));
        repository.insert(new Course(3, "Learn AWS", "Udemy"));

        repository.delete(3);

        System.out.println(repository.select(2));
    }
}
