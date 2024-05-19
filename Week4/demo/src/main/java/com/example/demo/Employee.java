package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "age")
    private Integer age;

    public Employee() { }

    public Employee(long id, String name, String department, Integer age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() { return department; }

    public void setDepartment(String department) { this.department = department; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department'" + department + '\'' +
                ", age=" + age +
                '}';
    }
}
