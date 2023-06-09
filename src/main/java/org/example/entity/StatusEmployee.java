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

    public StatusEmployee(String name) {
        this.name = name;
    }

    public StatusEmployee(long id) {
        this.id = id;
    }

    public StatusEmployee() {
        this.name = "";
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

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusEmployee that = (StatusEmployee) o;

        if (id != that.id) return false;
        return name.equals(that.name);
    }


    @Override
    public String toString() {
        return "StatusEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
