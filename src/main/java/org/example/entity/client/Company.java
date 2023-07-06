package org.example.entity.client;

import jakarta.persistence.*;

@Entity
@Table(name = "company_client")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "business_address")
    private String businessAddress;
    @Column(name = "fact_address")
    private String factAddress;
    @Column(name = "email")
    private String email;

    public Company(){

    }

    public Company(long id, String name, String businessAddress, String factAddress, String email) {
        this.id = id;
        this.name = name;
        this.businessAddress = businessAddress;
        this.factAddress = factAddress;
        this.email = email;
    }

    public Company(String name, String businessAddress, String factAddress, String email) {
        this.name = name;
        this.businessAddress = businessAddress;
        this.factAddress = factAddress;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getFactAddress() {
        return factAddress;
    }

    public void setFactAddress(String factAddress) {
        this.factAddress = factAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", factAddress='" + factAddress + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
