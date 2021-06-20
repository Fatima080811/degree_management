package com.example.todolist;

public class Employee {
    private String id,name,roll,email,passing, department;

    public Employee() {
    }

    public Employee(String id, String name,String roll, String email, String passing, String department) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.email = email;
        this.passing = passing;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassing() {
        return passing;
    }

    public void setPassing(String passing) {
        this.passing = passing;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoll() {
        return roll;
    }
    public void setRoll(String roll) {
        this.roll = roll;
    }
}
