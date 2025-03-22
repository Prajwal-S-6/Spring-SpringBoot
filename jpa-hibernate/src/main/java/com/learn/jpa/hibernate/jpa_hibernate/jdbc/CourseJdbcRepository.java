package com.learn.jpa.hibernate.jpa_hibernate.jdbc;

import com.learn.jpa.hibernate.jpa_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final String INSERT_QUERY =
            """
            INSERT into COURSE values(?, ?, ?);
            """;

    private static final String DELETE_QUERY =
            """
            DELETE from COURSE where id=?;
            """;

    private static final String SELECT_QUERY =
            """
            SELECT * from COURSE where id=?;
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course select(long id) {
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<Course>(Course.class), id);
        // ResultSet -> Bean using Row Mapper(BeanPropertyRowMapper<>())
    }
}
