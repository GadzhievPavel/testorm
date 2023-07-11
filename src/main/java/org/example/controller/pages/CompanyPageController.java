package org.example.controller.pages;

import org.example.entity.client.Company;
import org.example.model.NameCompany;
import org.example.repository.CompanyRepository;
import org.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(path = "/create_company_page")
    public ModelAndView getCreationUserPage() {
        ArrayList<Company> companies = new ArrayList<>();
        return getPageCreate(companies);
    }

    public ModelAndView getPageCreate(ArrayList<Company> companies) {
        ModelAndView view = new ModelAndView();
        view.setViewName("create_clients.html");
        NameCompany nameCompany = new NameCompany();
        view.addObject("nameCompany", nameCompany);
        ArrayList<Company> companyArrayList = new ArrayList<>();
        if (companies.isEmpty()) {
            companyArrayList = (ArrayList<Company>) companyService.findAll();
        }else {
            companyArrayList = companies;
        }

        view.addObject("companies", companyArrayList);
        return view;
    }

    @GetMapping(path = "/search_company")
    public ModelAndView findCompany(@ModelAttribute NameCompany nameCompany) {
        ArrayList<Company> companies = (ArrayList<Company>) companyService.getCompaniesByName(nameCompany.getName());
        ModelAndView view = new ModelAndView();
        return getPageCreate(companies);
    }
}
