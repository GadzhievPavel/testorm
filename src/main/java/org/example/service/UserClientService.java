package org.example.service;

import org.example.entity.client.Company;
import org.example.entity.client.UserClient;
import org.example.model.NameCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Service
public class UserClientService {
    @Autowired
    CompanyService companyService;
    public ModelAndView getCreationPage(ArrayList<Company> companies){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create_clients.html");
        NameCompany nameCompany = new NameCompany();
        modelAndView.addObject("nameCompany", nameCompany);

        if(companies.isEmpty()){
            companies = (ArrayList<Company>) companyService.findAll();
        }
        modelAndView.addObject("companies", companies);
        modelAndView.addObject("newClient", new UserClient());
        return modelAndView;
    }
}
