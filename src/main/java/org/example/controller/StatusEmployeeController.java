package org.example.controller;

import org.example.entity.StatusEmployee;
import org.example.repository.StatusEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/v1")
public class StatusEmployeeController {

    @Autowired
    private StatusEmployeeRepository statusEmployeeRepository;

    @GetMapping(path = "/getstatus")
    public ModelAndView getAllStatus(){
        var listStatus = statusEmployeeRepository.findAll();
        ModelAndView view = new ModelAndView();
        view.setViewName("status.html");
        view.addObject("listStatus",listStatus);
        return view;
    }

    @GetMapping(path = "/getstatus", params = {"id"})
    public ResponseEntity getStatusById(@RequestParam Long id){
        return ResponseEntity.ok().body(statusEmployeeRepository.findById(id));
    }
    @PostMapping(path = "/create_status")
    public ResponseEntity createStatus(@RequestBody StatusEmployee statusEmployee){
        statusEmployeeRepository.save(statusEmployee);
        return ResponseEntity.ok().body("add new status");
    }

    @DeleteMapping(path = "/deletestatus", params = {"id"})
    public ResponseEntity deleteStatus(@RequestParam Long id){
        statusEmployeeRepository.deleteById(id);
        return ResponseEntity.ok().body("delete status");
    }
}
