package com.learn.jpa.hibernate.jpa_hibernate.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentJpaRepository {

    @PersistenceContext
    EntityManager manager;

    public void insert(Student student) {
        manager.merge(student);
    }

    public Student selectById(long id) {
        return manager.find(Student.class, id);
    }

    public void findAndDeletebyId(long id) {
        Student student = manager.find(Student.class, id);
        manager.remove(student);
    }
}
