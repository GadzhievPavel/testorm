package org.example.controller.pages;

import org.example.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/pages")
public class CompanyPageController {
    @Autowired
    CompanyRepository companyRepository;

    private ModelAndView getPage(){
        ModelAndView view = new ModelAndView();
        view.setViewName("");
        return view;
    }
}
