package com.learnings.spring.mvc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("employee")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        Integer savedEmpId = employeeService.addEmployee(employee);
        return ResponseEntity.created(UriComponentsBuilder.fromUriString("/api/employee/{savedEmpId}").build(savedEmpId)).build();
    }

    @PutMapping("employee/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

}
