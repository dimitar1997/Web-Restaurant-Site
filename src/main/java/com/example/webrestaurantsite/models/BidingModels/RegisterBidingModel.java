package com.example.webrestaurantsite.models.BidingModels;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class RegisterBidingModel {
    private String name;
    private String middleName;
    private String finalName;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;
    private String role;

    public RegisterBidingModel() {
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterBidingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public RegisterBidingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public RegisterBidingModel setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @NotNull
    public String getFinalName() {
        return finalName;
    }

    public RegisterBidingModel setFinalName(String finalName) {
        this.finalName = finalName;
        return this;
    }

    @NotBlank
    @Email
    public String getEmail() {
        return email;
    }

    public RegisterBidingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank
    @Size(min = 5, max = 20)
    public String getUsername() {
        return username;
    }

    public RegisterBidingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank
    @Size(min = 6, max = 20)
    public String getPassword() {
        return password;
    }

    public RegisterBidingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public RegisterBidingModel setRole(String role) {
        this.role = role;
        return this;
    }
}
