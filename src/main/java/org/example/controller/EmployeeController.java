package org.example.controller;

import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.StatusEmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private StatusEmployeeRepository statusEmployeeRepository;

    @GetMapping("/employees")
    public ResponseEntity getAllEmployees(){
        return ResponseEntity.ok().body(employeeRepository.findAll());
    }

    @PostMapping(path = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok().body("add");
    }
}