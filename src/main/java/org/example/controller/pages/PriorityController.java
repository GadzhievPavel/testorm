package org.example.controller.pages;

import org.example.entity.Priority;
import org.example.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/pages")
public class PriorityController {

    @Autowired
    private PriorityRepository priorityRepository;

    @PostMapping(path = "/create_priority")
    public ModelAndView createPriority(@ModelAttribute Priority priority){
        priorityRepository.save(priority);
        return getPage();
    }

    @GetMapping(path = "/priorities")
    public ModelAndView getPriorities(){
        return getPage();
    }
    private ModelAndView getPage(){
        ModelAndView view = new ModelAndView();
        var priorities =priorityRepository.findAll();
        view.setViewName("priorities.html");
        view.addObject("PrioritiesIsEmpty",priorities.isEmpty());
        view.addObject("priorities",priorities);
        view.addObject("priority", new Priority());
        return view;
    }
}
