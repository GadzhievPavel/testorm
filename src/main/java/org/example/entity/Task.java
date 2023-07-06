package org.example.entity;

import jakarta.persistence.*;
import org.example.entity.client.UserClient;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Table(name = "tasks")
@Component
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "theme")
    private String theme;
    @Column(name = "text_task")
    private String textTask;
    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;
    @Column(name = "date_create")
    private Date dateCreate;
    @Column(name = "date_start_processing")
    private Date dateStartProcessing;
    @Column(name = "date_finish_processing")
    private Date dateFinishProcessing;
    @ManyToOne
    @JoinColumn(name = "employee_executor_id")
    private Employee employeeExecutor;

    @ManyToOne
    @JoinColumn(name = "id_user_client")
    private UserClient userClient;

    public Task() {

    }

    public Task(long id, String theme, String textTask, Priority priority, Date dateCreate, Date dateStartProcessing, Date dateFinishProcessing, Employee employeeExecutor, UserClient userClient) {
        this.id = id;
        this.theme = theme;
        this.textTask = textTask;
        this.priority = priority;
        this.dateCreate = dateCreate;
        this.dateStartProcessing = dateStartProcessing;
        this.dateFinishProcessing = dateFinishProcessing;
        this.employeeExecutor = employeeExecutor;
        this.userClient = userClient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTextTask() {
        return textTask;
    }

    public void setTextTask(String textTask) {
        this.textTask = textTask;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateStartProcessing() {
        return dateStartProcessing;
    }

    public void setDateStartProcessing(Date dateStartProcessing) {
        this.dateStartProcessing = dateStartProcessing;
    }

    public Date getDateFinishProcessing() {
        return dateFinishProcessing;
    }

    public void setDateFinishProcessing(Date dateFinishProcessing) {
        this.dateFinishProcessing = dateFinishProcessing;
    }

    public Employee getEmployeeExecutor() {
        return employeeExecutor;
    }

    public void setEmployeeExecutor(Employee employeeExecutor) {
        this.employeeExecutor = employeeExecutor;
    }

    public UserClient getUserClient() {
        return userClient;
    }

    public void setUserClient(UserClient userClient) {
        this.userClient = userClient;
    }
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", textTask='" + textTask + '\'' +
                ", priority=" + priority +
                ", dateCreate=" + dateCreate +
                ", dateStartProcessing=" + dateStartProcessing +
                ", dateFinishProcessing=" + dateFinishProcessing +
                ", employeeExecutor=" + employeeExecutor +
                '}';
    }
}
