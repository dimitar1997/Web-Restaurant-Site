package com.example.webrestaurantsite.models.entity;

import com.example.webrestaurantsite.models.entity.enums.RoleEnums;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

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
    private List<Reservation> reservations;

    public User() {
    }

    @OneToMany
    public List<Reservation> getReservations() {
        return reservations;
    }

    public User setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
        return this;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

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
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotNull
    @Size(min = 6)
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
