package com.learnings.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoJpa extends JpaRepository<User, Integer> {
}
