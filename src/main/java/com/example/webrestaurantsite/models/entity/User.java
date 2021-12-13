package com.example.webrestaurantsite.models.entity;

import com.example.webrestaurantsite.models.entity.enums.RoleEnums;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends BasicEntity {
    private String name;
    private String middleName;
    private String finalName;
    private String email;
    private String username;
    private String password;
    private RoleEnums role;


    public User() {
    }


    @NotNull
    @Column(unique = true)
    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    @Column
    public String getMiddleName() {
        return middleName;
    }

    public User setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @NotNull
    public String getFinalName() {
        return finalName;
    }

    public User setFinalName(String finalName) {
        this.finalName = finalName;
        return this;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotNull
    @Size(min = 5)
    @Column(nullable = false)
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotNull
    @Size(min = 6, max = 20)
    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public RoleEnums getRole() {
        return role;
    }

    public User setRole(RoleEnums role) {
        this.role = role;
        return this;
    }
}
