package org.example.controller;

import org.example.entity.Employee;
import org.example.entity.StatusEmployee;
import org.example.repository.EmployeeRepository;
import org.example.repository.StatusEmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private StatusEmployeeRepository statusEmployeeRepository;

    @GetMapping("/employees")
    public ResponseEntity getAllEmployees() {
        return ResponseEntity.ok().body(employeeRepository.findAll());
    }

    @PostMapping(path = "/employees")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        List<Employee> employees = employeeRepository.findAll();
        List<StatusEmployee> statusEmployees = statusEmployeeRepository.findAll();
        ModelAndView view = new ModelAndView();
        view.addObject("employee", new Employee());
        view.setViewName("employees.html");
        view.addObject("employees", employees);
        view.addObject("statuses",statusEmployees);
        return view;
    }

    @PostMapping(path = "/delete_employee")
    public ModelAndView deleteEmployee(@ModelAttribute Employee employee){
        employeeRepository.deleteById(employee.getId());
        List<Employee> employees = employeeRepository.findAll();
        ModelAndView view = new ModelAndView();
        view.addObject("employee", new Employee());
        view.setViewName("employees.html");
        view.addObject("employees", employees);
        return view;
    }

    @GetMapping(path = "/employees_page")
    public ModelAndView getEmployeesPage() {

        List<Employee> employees = employeeRepository.findAll();
        List<StatusEmployee> statusEmployees = statusEmployeeRepository.findAll();
        ModelAndView view = new ModelAndView();
        view.addObject("employee", new Employee());
        view.setViewName("employees.html");
        view.addObject("employees", employees);
        view.addObject("statuses",statusEmployees);
        return view;
    }
}