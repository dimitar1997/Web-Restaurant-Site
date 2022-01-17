package com.example.webrestaurantsite.models.view;

public class ReservationCustomViewModel {
    private Long id;
    private String imgUrl;
    private String name;

    public Long getId() {
        return id;
    }

    public ReservationCustomViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ReservationCustomViewModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public ReservationCustomViewModel setName(String name) {
        this.name = name;
        return this;
    }
}
