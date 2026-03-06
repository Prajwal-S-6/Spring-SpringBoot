package com.learnings.spring.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest()
@Sql(scripts = {"/schema.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@EntityScan("com.learnings.spring.mvc")
@EnableJpaRepositories("com.learnings.spring.mvc")
class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void shouldFindAllEmployees() {
        List<Employee> employeeList = employeeDao.findAll();

        assertThat(employeeList.size()).isEqualTo(2);
    }
}