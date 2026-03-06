package com.learnings.spring.mvc;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest()
@Sql(scripts = {"/schema.sql", "/data.sql"})
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

    @Test
    @DirtiesContext
    @Rollback
    public void shouldDeleteEmployeeById() {
        employeeDao.deleteById(1);

        List<Employee> employeeList = employeeDao.findAll();

        assertThat(employeeList.size()).isEqualTo(1);
        assertThat(employeeList.stream().filter(employee -> employee.getName() == "e1").toList().size()).isEqualTo(0);

    }

    @Test
    @DirtiesContext
    @Rollback
    public void shouldAddEmployee() {
        Employee employee = new Employee();
        employee.setSalary(2000);
        employee.setName("e3");
        employeeDao.save(employee);

        List<Employee> employeeList = employeeDao.findAll();

        assertThat(employeeList.size()).isEqualTo(3);
        assertThat(employeeList.stream().filter(e -> e.getName() == "e3").toList().size()).isEqualTo(1);

    }
}