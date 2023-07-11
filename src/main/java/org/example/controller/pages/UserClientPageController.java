package org.example.controller.pages;

import org.example.entity.client.UserClient;
import org.example.model.NameCompany;
import org.example.repository.UserClientRepository;
import org.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/pages")
public class UserClientPageController {
    @Autowired
    CompanyService companyService;
    @Autowired
    private UserClientRepository clientRepository;

    @GetMapping(path = "/clients")
    public ModelAndView getClients(){
        return getPage();
    }

    @PostMapping(path="/create_clients")
    public ModelAndView createClient(@ModelAttribute UserClient userClient){
        clientRepository.save(userClient);
        return getPage();
    }

    private ModelAndView getPage(){
        ModelAndView view = new ModelAndView();
        view.setViewName("clients.html");
        view.addObject("client", new UserClient());
        view.addObject("clients",clientRepository.findAll());
        return view;
    }
}
