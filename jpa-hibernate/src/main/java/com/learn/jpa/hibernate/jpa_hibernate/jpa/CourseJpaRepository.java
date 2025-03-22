package com.learn.jpa.hibernate.jpa_hibernate.jpa;

import com.learn.jpa.hibernate.jpa_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
//    @Autowired   // this will work but will go with more specific annotation @PeristanceContext
//    private EntityManager entityManager;

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course select(long id) {
        return  entityManager.find(Course.class, id);
    }

    public void delete(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
