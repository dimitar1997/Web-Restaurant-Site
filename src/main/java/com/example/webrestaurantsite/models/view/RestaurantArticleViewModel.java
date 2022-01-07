package com.example.webrestaurantsite.models.view;


public class RestaurantArticleViewModel {
    private Long id;
    private String imageUrl;
    private String name;

    public Long getId() {
        return id;
    }

    public RestaurantArticleViewModel setId(Long id) {
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
