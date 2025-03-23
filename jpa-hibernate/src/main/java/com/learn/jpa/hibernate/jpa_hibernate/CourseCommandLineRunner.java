package com.learn.jpa.hibernate.jpa_hibernate;

import com.learn.jpa.hibernate.jpa_hibernate.course.Course;
import com.learn.jpa.hibernate.jpa_hibernate.course.springdatajpa.CourseSpringDataJPARepository;
import com.learn.jpa.hibernate.jpa_hibernate.jdbc.CourseJdbcRepository;
import com.learn.jpa.hibernate.jpa_hibernate.jpa.CourseJpaRepository;
import com.learn.jpa.hibernate.jpa_hibernate.student.Student;
import com.learn.jpa.hibernate.jpa_hibernate.student.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository jpaRepository;
//
//    @Autowired
//    StudentJpaRepository studentJpaRepository;

    @Autowired
    private CourseSpringDataJPARepository repository;

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

//        jpaRepository.insert(new Course(1, "Learn Azure JPA", "Udemy"));
//        jpaRepository.insert(new Course(2, "Learn GCP JPA", "Udemy"));
//        jpaRepository.insert(new Course(3, "Learn AWS JPA", "Udemy"));
//
//        // this will update since id=1 is already is present
//        jpaRepository.insert(new Course(1, "Learn Azure JPA", "Coursera"));
//
//        jpaRepository.delete(3);
//
//        System.out.println(jpaRepository.select(2));

//        studentJpaRepository.insert(new Student(1, "Prajwal", 25));
//        studentJpaRepository.insert(new Student(2, "Prashant", 24));
//        studentJpaRepository.insert(new Student(3, "Prakash", 23));
//
//        System.out.println(studentJpaRepository.selectById(2));

            // spring-data jpa
        repository.save(new Course(1, "Learn Azure", "Udemy"));
        repository.save(new Course(2, "Learn GCP", "Udemy"));
        repository.save(new Course(3, "Learn AWS", "Udemy"));

        repository.deleteById(3l);

        System.out.println(repository.findAll());
        System.out.println(repository.findByAuthor("Udemy"));
        System.out.println(repository.findByAuthor("Learn AWS"));
    }
}
