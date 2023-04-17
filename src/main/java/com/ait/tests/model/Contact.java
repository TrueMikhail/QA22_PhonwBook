package com.ait.tests.model;

public class Contact {
    private String name;
    private String surName;
    private String phone;
    private String email;
    private String adress;
    private String description;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }

    public String getDescription() {
        return description;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setSurName(String surName) {
        this.surName = surName;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public Contact setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}