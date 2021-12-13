package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.entity.Town;
import com.example.webrestaurantsite.repository.TownRepository;
import com.example.webrestaurantsite.service.TownService;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void initializeTown() {

    }
}