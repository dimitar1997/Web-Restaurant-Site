package com.example.webrestaurantsite.models.view;

public class ReservationViewDetailsModel {
    private Long id;
    private String imgUrl;
    private String nameRestaurant;
    private String firstName;
    private String lastName;
    private String date;
    private int people;

    public int getPeople() {
        return people;
    }

    public ReservationViewDetailsModel setPeople(int people) {
        this.people = people;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ReservationViewDetailsModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ReservationViewDetailsModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public ReservationViewDetailsModel setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ReservationViewDetailsModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ReservationViewDetailsModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDate() {
        return date;
    }

    public ReservationViewDetailsModel setDate(String date) {
        this.date = date;
        return this;
    }
}
