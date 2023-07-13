package org.example.controller.pages;

import org.example.entity.client.Company;
import org.example.entity.client.UserClient;
import org.example.model.NameCompany;
import org.example.repository.UserClientRepository;
import org.example.service.CompanyService;
import org.example.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
@RequestMapping("/pages")
public class UserClientPageController {
    @Autowired
    UserClientService clientService;
    @Autowired
    private UserClientRepository clientRepository;

    @GetMapping(path = "/clients")
    public ModelAndView getClients(){
        return clientService.getPage();
    }

    @PostMapping(path="/create_client")
    public ModelAndView createClient(@ModelAttribute UserClient newClient){
        System.out.println(newClient);
        clientRepository.save(newClient);
        return clientService.getPage();
    }

    @GetMapping(path="/create_client_page")
    public ModelAndView getCreateClientPage(){
        ArrayList<Company> companies = new ArrayList<>();
        return clientService.getCreationPage(companies);
    }


}
