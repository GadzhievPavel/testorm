package org.example.model;

import org.springframework.stereotype.Component;

@Component
public class NameCompany {
    private String name;

    public NameCompany(){

    }

    public NameCompany(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
