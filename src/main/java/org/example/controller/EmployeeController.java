package org.example.controller;

import org.apache.commons.logging.Log;
import org.example.entity.Employee;
import org.example.entity.StatusEmployee;
import org.example.repository.EmployeeRepository;
import org.example.repository.StatusEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

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
        ModelAndView view = getPageUsers();
        return view;
    }

    @PostMapping(path = "/delete_employee")
    public ModelAndView deleteEmployee(@ModelAttribute Employee employee) {
        employeeRepository.deleteById(employee.getId());
        ModelAndView view = getPageUsers();
        return view;
    }

    @GetMapping(path = "/employees_page")
    public ModelAndView getEmployeesPage() {
        ModelAndView view = getPageUsers();
        return view;
    }

    @GetMapping(path = "employees_editor_page")
    public ModelAndView getEmployeesEditorPage(@ModelAttribute Employee employee){
        List<StatusEmployee> statusEmployees = statusEmployeeRepository.findAll();
        employee = employeeRepository.findById(employee.getId()).get();
        System.out.println(employee.toString());
        //Optional<Employee> employeeOptional = employeeRepository.findById(Long.valueOf(employeeId));
        //Employee employee = employeeOptional.get();
        ModelAndView view = new ModelAndView();
        view.setViewName("edit_employees.html");
        view.addObject("statuses", statusEmployees);
        view.addObject("selectStatus",employee.getStatus());
        //view.addObject("employee", employee);
        return view;
    }
    @PostMapping(path = "update_employee")
    public ModelAndView updateEmployee(@ModelAttribute Employee employee){
        employeeRepository.save(employee);
        ModelAndView modelAndView = getPageUsers();
        return modelAndView;
    }

    private ModelAndView getPageUsers() {
        ModelAndView view = new ModelAndView();
        List<Employee> employees = employeeRepository.findAll();
        List<StatusEmployee> statusEmployees = statusEmployeeRepository.findAll();
        view.addObject("employee", new Employee());
        view.setViewName("employees.html");
        view.addObject("employees", employees);
        view.addObject("statuses", statusEmployees);
        return view;
    }
}