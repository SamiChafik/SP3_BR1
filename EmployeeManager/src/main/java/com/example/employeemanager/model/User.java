package com.example.employeemanager.model;

public class User {
    private int id;
    private String firstName,familyName,email,phoneNumber,post;
    private double salaire;

    public User(int id, String firstName, String familyName, String email, String phoneNumber, String post, double salary) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.familyName = familyName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.post = post;
        this.salaire = salaire;
    }

    public User(String firstName, String familyName, String email, String phoneNumber, String post, double salaire) {
        super();
        this.firstName = firstName;
        this.familyName = familyName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.post = post;
        this.salaire = salaire;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
}
