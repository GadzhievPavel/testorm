package org.example.controller.pages;

import org.example.entity.Priority;
import org.example.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/pages")
public class PriorityPageController {

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
    @GetMapping(path = "/page_edit_priority")
    public ModelAndView getEditPriority(@ModelAttribute Priority priority){
        ModelAndView view = new ModelAndView();
        view.setViewName("edit_priority.html");
        view.addObject("priority",priority);
        return view;
    }

    @PostMapping(path = "edit_priority")
    public ModelAndView updatePriority(@ModelAttribute Priority priority){
        var priorityDB =priorityRepository.findById(priority.getId()).get();
        priorityDB.setName(priority.getName());
        priorityDB.setValue(priority.getValue());
        priorityRepository.save(priorityDB);
        return getPage();
    }

    @PostMapping(path = "delete_priority")
    public ModelAndView deletePriority(@ModelAttribute Priority priority){
        priorityRepository.deleteById(priority.getId());
        return getPage();
    }
}
