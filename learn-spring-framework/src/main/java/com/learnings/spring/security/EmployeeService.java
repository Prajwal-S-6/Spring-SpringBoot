package com.learnings.spring.security;

import com.learnings.spring.mvc.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public Integer addEmployee(Employee employee) {
        Employee savedEmployee = employeeDao.save(employee);
        return savedEmployee.id;
    }

    public Employee updateEmployee(Integer empId, Employee employee) {
        Employee existingEmployee = employeeDao.findById(empId).orElseThrow(EmployeeNotFoundException::new);
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setName(employee.getName());
        return employeeDao.save(existingEmployee);
    }

    public Employee updateSalary(Integer id, Employee employee1) {
        Employee employee = employeeDao.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employee.setSalary(employee1.getSalary());
        return employeeDao.save(employee);

    }

    public void deleteEmployeeById(Integer id) {
        Employee employee = employeeDao.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employeeDao.delete(employee);
    }

    public void registerEmployee(String name, String password, String role) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPassword(bCryptPasswordEncoder.encode(password));
        employee.setRole(role);
        employeeDao.save(employee);
    }
}
