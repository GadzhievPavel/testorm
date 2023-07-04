package org.example.controller.pages;

import org.example.entity.StatusEmployee;
import org.example.repository.StatusEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/pages")
public class StatusEmployeePageController {

    @Autowired
    private StatusEmployeeRepository statusEmployeeRepository;

    @GetMapping("/statuses")
    public ModelAndView getStatuses() {
        return getPage();
    }

    @PostMapping(path = "/create_status")
    public ModelAndView createStatus(@ModelAttribute StatusEmployee statusEmployee) {
        statusEmployeeRepository.save(statusEmployee);
        return getPage();
    }

    @PostMapping(path = "/delete_status")
    public ModelAndView deleteStatus(@ModelAttribute StatusEmployee statusEmployee) {
        System.out.println(statusEmployee);
        statusEmployeeRepository.delete(statusEmployee);
        return getPage();
    }

    @PostMapping(path = "/update_status")
    public ModelAndView updateStatus(@ModelAttribute StatusEmployee statusEmployee){
        System.out.println(statusEmployee);
        StatusEmployee status = statusEmployeeRepository.findById(statusEmployee.getId()).get();
        System.out.println(status);
        status.setName(statusEmployee.getName());
        statusEmployeeRepository.save(status);
        return getPage();
    }

    @GetMapping(path = "/get_edit_pages")
    public ModelAndView getEditorStatusPage(@ModelAttribute StatusEmployee statusEmployee){
        ModelAndView view = new ModelAndView();
        view.setViewName("edit_status.html");
        view.addObject(statusEmployee);
        return view;
    }
    private ModelAndView getPage() {
        var listStatus = statusEmployeeRepository.findAll();
        ModelAndView view = new ModelAndView();
        view.setViewName("status.html");
        view.addObject("statusEmployee", new StatusEmployee());
        view.addObject("listStatus", listStatus);
        return view;
    }
}
