package org.example.service;

import org.example.entity.client.Company;
import org.example.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getCompaniesByName(String name){
        if(name.isEmpty()){
            ArrayList<Company> companies = new ArrayList<>();
            companyRepository.findAll().iterator().forEachRemaining(companies::add);
            return companies;
        }else{
            return companyRepository.getCompaniesByNameContaining(name);
        }
    }

    public void save(Company company){
        companyRepository.save(company);
    }

    public void delete(Company company){
        companyRepository.delete(company);
    }
    public Company findById(Long id){
        return companyRepository.findById(id).get();
    }

    public List<Company> findAll(){
        ArrayList<Company> companies = new ArrayList<>();
        companyRepository.findAll().iterator().forEachRemaining(companies::add);
        return companies;
    }

    public void update(Company company){
        var companyUpdating = companyRepository.findById(company.getId()).get();
        companyUpdating.setName(company.getName());
        companyUpdating.setFactAddress(company.getFactAddress());
        companyUpdating.setBusinessAddress(company.getBusinessAddress());
        companyUpdating.setEmail(company.getEmail());
        companyRepository.save(companyUpdating);
    }
}
