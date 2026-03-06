package com.learnings.spring.mvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void shouldGetAllEmployees() {
        Mockito.when(employeeDao.findAll()).thenReturn(List.of(new Employee(1, "A", 200)));

        List<Employee> employees = employeeService.getAllEmployees();

        assertThat(employees.size()).isEqualTo(1);
        assertThat(employees.getFirst().getName()).isEqualTo("A");

    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenDeleteingNotExistingEmployee() {
        Mockito.doThrow(EmployeeNotFoundException.class).when(employeeDao).delete(Mockito.any());

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.deleteEmployeeById(1));
    }
}