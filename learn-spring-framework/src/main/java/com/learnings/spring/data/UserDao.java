package com.learnings.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * from USERS where id=1",
                (rs, rowNum) -> new User(rs.getString("name"), rs.getInt("id")));
    }

    public int getCount() {
        return jdbcTemplate.queryForObject("SELECT count(*) from USERS", Integer.class);
    }
}
