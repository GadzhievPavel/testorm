package org.example.controller.pages;

import org.example.entity.client.Company;
import org.example.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/pages")
public class CompanyPageController {
    @Autowired
    CompanyRepository companyRepository;
    @GetMapping(path = "/companies")
    public ModelAndView getCompany(){
        return getPage();
    }
    @PostMapping(path = "/create_company")
    public ModelAndView createCompany(@ModelAttribute Company company){
        companyRepository.save(company);
        return getPage();
    }

    @PostMapping(path = "/delete_company")
    public ModelAndView deleteCompany(@ModelAttribute Company company){
        System.out.println(company);
        companyRepository.delete(company);
        return getPage();
    }

    @GetMapping(path = "/get_edit_company")
    public ModelAndView getEditPage(@ModelAttribute Company company){
        ModelAndView view = new ModelAndView();
        view.setViewName("edit_company.html");
        view.addObject("company", company);
        return view;
    }

    @PostMapping(path ="/update_company")
    public ModelAndView updateCompany(@ModelAttribute Company updateCompany){
        var company = companyRepository.findById(updateCompany.getId()).get();
        company.setName(updateCompany.getName());
        company.setEmail(updateCompany.getEmail());
        company.setBusinessAddress(updateCompany.getBusinessAddress());
        company.setFactAddress(updateCompany.getFactAddress());
        companyRepository.save(company);
        return getPage();
    }
    private ModelAndView getPage(){
        ModelAndView view = new ModelAndView();
        view.setViewName("company.html");
        view.addObject("company",new Company());
        var companies = companyRepository.findAll();
        view.addObject("companies", companies);
        view.addObject("CompanyIsEmpty", companies.isEmpty());
        return view;
    }
}
