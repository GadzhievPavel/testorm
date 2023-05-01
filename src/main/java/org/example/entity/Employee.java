package org.example.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "employees")
@Component
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String emailId;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEmployee status;

    public Employee() {

    }

    public Employee(String firstName, String lastName, String emailId, StatusEmployee status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.status = status;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public StatusEmployee getStatus() {
        return status;
    }

    public void setStatus(StatusEmployee status) {
        this.status = status;
    }
}