package com.example.webrestaurantsite.models.view;

public class ListOfPeopleViewModel {
    String fullName;
    int peopleCount;

    public String getFullName() {
        return fullName;
    }

    public ListOfPeopleViewModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public ListOfPeopleViewModel setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
        return this;
    }
}
