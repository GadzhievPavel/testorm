package org.example.dto;

import org.example.entity.client.Company;
import org.example.entity.client.UserClient;
import org.example.model.NameCompany;

import java.util.ArrayList;

public class CreateNewUserDTO {
    private UserClient userClient;
    private NameCompany nameCompany;
    private ArrayList<Company> companies;

    public CreateNewUserDTO(){

    }

    public CreateNewUserDTO(UserClient userClient, NameCompany nameCompany, ArrayList<Company> companies) {
        this.userClient = userClient;
        this.nameCompany = nameCompany;
        this.companies = companies;
    }

    public UserClient getUserClient() {
        return userClient;
    }

    public void setUserClient(UserClient userClient) {
        this.userClient = userClient;
    }

    public NameCompany getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(NameCompany nameCompany) {
        this.nameCompany = nameCompany;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<Company> companies) {
        this.companies = companies;
    }
}
