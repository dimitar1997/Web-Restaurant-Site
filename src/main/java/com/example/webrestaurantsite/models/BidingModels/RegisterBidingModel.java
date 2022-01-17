package com.example.webrestaurantsite.models.BidingModels;

import com.example.webrestaurantsite.models.entity.enums.RoleEnums;
import com.example.webrestaurantsite.models.validator.UniqueUserName;

import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class RegisterBidingModel {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;
    private RoleEnums role;

    public RegisterBidingModel() {
    }

    @NotBlank
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterBidingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @NotBlank
    public String firstName() {
        return firstName;
    }

    public RegisterBidingModel firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public RegisterBidingModel setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @NotBlank
    public String getLastName() {
        return lastName;
    }

    public RegisterBidingModel setLastName(String lastName) {
        this.lastName = lastName;
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
    @Size(min = 4, max = 20)
    @UniqueUserName(message = "Полето е задължително и трябва да бъде между 5 и 20 символа!")
    public String getUsername() {
        return username;
    }

    public RegisterBidingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank
    @Size(min = 5, max = 20)
    public String getPassword() {
        return password;
    }

    public RegisterBidingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank
    public String getFirstName() {
        return firstName;
    }

    public RegisterBidingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @NotNull
    public RoleEnums getRole() {
        return role;
    }

    public RegisterBidingModel setRole(RoleEnums role) {
        this.role = role;
        return this;
    }
}
