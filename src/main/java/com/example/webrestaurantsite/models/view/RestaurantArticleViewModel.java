package com.example.webrestaurantsite.models.view;

import java.io.File;

public class RestaurantArticleViewModel {
    private long id;
    private String imageUrl;
    private String name;

    public long getId() {
        return id;
    }

    public RestaurantArticleViewModel setId(long id) {
        this.id = id;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RestaurantArticleViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public RestaurantArticleViewModel setName(String name) {
        this.name = name;
        return this;
    }
}
