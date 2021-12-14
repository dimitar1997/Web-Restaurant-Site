package com.example.webrestaurantsite.service;

import com.example.webrestaurantsite.service.impl.UserDetailsImpl;

public interface TownService {
    void add(String townName, UserDetailsImpl currentUser);
}
