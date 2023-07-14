package org.example.service;

import org.example.dto.CreateNewUserDTO;
import org.example.entity.client.Company;
import org.example.entity.client.UserClient;
import org.example.model.NameCompany;
import org.example.repository.UserClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Service
public class UserClientService {
    @Autowired
    CompanyService companyService;
    @Autowired
    UserClientRepository clientRepository;
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
    public ModelAndView getCreationPage1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create_clients.html");
        CreateNewUserDTO createNewUserDTO = new CreateNewUserDTO();
        createNewUserDTO.setUserClient(new UserClient());
        createNewUserDTO.setCompanies((ArrayList<Company>) companyService.findAll());
        createNewUserDTO.setNameCompany(new NameCompany());
        modelAndView.addObject("newUserDTO", createNewUserDTO);
        return modelAndView;
    }

    public ModelAndView getCreationPage1(CreateNewUserDTO createNewUserDTO){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create_clients.html");
        modelAndView.addObject("newUserDTO", createNewUserDTO);
        return modelAndView;
    }

    public ModelAndView getPage(){
        ModelAndView view = new ModelAndView();
        view.setViewName("clients.html");
        ArrayList<UserClient> userClients = (ArrayList<UserClient>) clientRepository.findAll();
        view.addObject("clients",userClients);
        return view;
    }

    public CreateNewUserDTO getCreateNewUserDTO(CreateNewUserDTO createNewUserDTO){
        ArrayList<Company> companies = (ArrayList<Company>) companyService.getCompaniesByName(createNewUserDTO.getNameCompany().getName());
        createNewUserDTO.setCompanies(companies);
        return createNewUserDTO;
    }
}
