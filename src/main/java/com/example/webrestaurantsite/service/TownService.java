package com.example.webrestaurantsite.service;


import com.example.webrestaurantsite.models.entity.Town;
import com.example.webrestaurantsite.models.view.AllTownsViewModel;

import java.io.IOException;
import java.util.List;

public interface TownService {
    void add() throws IOException;
    List<AllTownsViewModel> getAllTowns();
}
