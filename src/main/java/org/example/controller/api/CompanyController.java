package org.example.controller.api;

import org.example.entity.client.Company;
import org.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping(path = "/companies")
    public ResponseEntity getCompanies(){
        return ResponseEntity.ok().body(companyService.findAll());
    }

    @PostMapping(path="/companies")
    public ResponseEntity createCompanies(@RequestBody Company company){
        companyService.save(company);
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping(path = "/update_company")
    public ResponseEntity updateCompany(@RequestBody Company company){
        companyService.update(company);
        return ResponseEntity.ok().body(company);
    }

    @PostMapping(path = "/delete_company")
    public ResponseEntity deleteCompany(@RequestBody Company company){
        companyService.delete(company);
        return ResponseEntity.ok().body("delete");
    }

    @GetMapping(path = "/company")
    public ResponseEntity getCompanyByName(@RequestParam String name){
        return ResponseEntity.ok().body(companyService.getCompaniesByName(name));
    }
}
