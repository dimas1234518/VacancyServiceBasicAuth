package com.zhevakin.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table (name = "t_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "Имя не может быть меньше двух знаком")
    private String empName;


    private String position;

    public Employee() {
    }

    public Employee(Long id, String empName, String position) {
        this.id = id;
        this.empName = empName;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
