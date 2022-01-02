package com.example.webrestaurantsite.models.view;

import java.io.File;

public class RestaurantArticleViewModel {
    private long id;
    private File file;
    private String name;

    public long getId() {
        return id;
    }

    public RestaurantArticleViewModel setId(long id) {
        this.id = id;
        return this;
    }

    public File getFile() {
        return file;
    }

    public RestaurantArticleViewModel setFile(File file) {
        this.file = file;
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
