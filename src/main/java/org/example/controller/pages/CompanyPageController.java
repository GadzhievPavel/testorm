package org.example.controller.pages;

import org.example.entity.client.Company;
import org.example.entity.client.UserClient;
import org.example.model.NameCompany;
import org.example.repository.CompanyRepository;
import org.example.service.CompanyService;
import org.example.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
@RequestMapping("/pages")
public class CompanyPageController {
    //    @Autowired
//    CompanyRepository companyRepository;
    @Autowired
    CompanyService companyService;
    @Autowired
    UserClientService clientService;

    @GetMapping(path = "/companies")
    public ModelAndView getCompany() {
        return getPage();
    }

    @PostMapping(path = "/create_company")
    public ModelAndView createCompany(@ModelAttribute Company company) {
        companyService.save(company);
        return getPage();
    }

    @PostMapping(path = "/delete_company")
    public ModelAndView deleteCompany(@ModelAttribute Company company) {
        System.out.println(company);
        companyService.delete(company);
        return getPage();
    }

    @GetMapping(path = "/get_edit_company")
    public ModelAndView getEditPage(@ModelAttribute Company company) {
        ModelAndView view = new ModelAndView();
        view.setViewName("edit_company.html");
        view.addObject("company", company);
        return view;
    }

    @PostMapping(path = "/update_company")
    public ModelAndView updateCompany(@ModelAttribute Company updateCompany) {
        companyService.update(updateCompany);
        return getPage();
    }

    private ModelAndView getPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("company.html");
        view.addObject("company", new Company());
        var companies = companyService.findAll();
        view.addObject("companies", companies);
        view.addObject("CompanyIsEmpty", companies.isEmpty());
        return view;
    }


    @GetMapping(path = "/search_company")
    public ModelAndView findCompany(@ModelAttribute NameCompany nameCompany,Model model) {
        System.out.println(nameCompany.getName());
        ArrayList<Company> companies = (ArrayList<Company>) companyService.getCompaniesByName(nameCompany.getName());
        return clientService.getCreationPage(companies);
    }


}
