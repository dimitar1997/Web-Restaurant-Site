package com.example.webrestaurantsite.models.entity;

import javax.persistence.*;


@Entity
@Table(name = "towns")
public class Town extends BasicEntity {
    private String name;


    public Town() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Town setName(String name) {
        this.name = name;
        return this;
    }

}
