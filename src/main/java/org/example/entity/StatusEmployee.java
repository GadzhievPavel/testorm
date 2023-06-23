package org.example.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "employees_status")
@Component
public class StatusEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    public StatusEmployee(String name){
        this.name = name;
    }

    public StatusEmployee(int id){
        this.id = id;
    }

    public StatusEmployee(){
        this.name="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }
}
