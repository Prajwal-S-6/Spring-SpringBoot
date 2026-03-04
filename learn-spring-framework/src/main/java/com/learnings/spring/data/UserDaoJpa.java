package com.learnings.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoJpa extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT * from users where name=?1", nativeQuery = true)
    public Users findByName(String name);
}
