package com.learnings.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Users> getUsers() {
        return jdbcTemplate.query("SELECT * from USERS where id=1",
                (rs, rowNum) -> new Users(rs.getInt("id"), rs.getString("name")));
    }

    public int getCount() {
        return jdbcTemplate.queryForObject("SELECT count(*) from USERS", Integer.class);
    }
}
