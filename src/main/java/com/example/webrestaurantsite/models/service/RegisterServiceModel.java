package com.example.webrestaurantsite.models.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class RegisterServiceModel {
    private String name;
    private String middleName;
    private String finalName;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;
    private String role;

    public RegisterServiceModel() {
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterServiceModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getName() {
        return name;
    }

    public RegisterServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public RegisterServiceModel setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }


    public String getFinalName() {
        return finalName;
    }

    public RegisterServiceModel setFinalName(String finalName) {
        this.finalName = finalName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }


    public String getUsername() {
        return username;
    }

    public RegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }


    public String getPassword() {
        return password;
    }

    public RegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public RegisterServiceModel setRole(String role) {
        this.role = role;
        return this;
    }
}
