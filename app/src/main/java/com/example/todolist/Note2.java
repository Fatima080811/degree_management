package com.example.todolist;

public class Note2 {

    private int id;
    private String roll;
    private String name;
    private String department;
    private String pass;
    private String mail;
    private String cgpa;
    private String contact;
    private String address;

    public Note2(String roll, String name, String department, String pass, String mail, String cgpa, String contact, String address) {
        this.roll = roll;
        this.name = name;
        this.department = department;
        this.pass = pass;
        this.mail = mail;
        this.cgpa = cgpa;
        this.contact = contact;
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
