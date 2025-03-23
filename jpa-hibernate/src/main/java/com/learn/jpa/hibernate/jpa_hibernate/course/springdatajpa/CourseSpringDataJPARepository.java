package com.learn.jpa.hibernate.jpa_hibernate.course.springdatajpa;

import com.learn.jpa.hibernate.jpa_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);

    List<Course> findByName(String name);

}
