package com.example.webrestaurantsite.service.impl;


import com.example.webrestaurantsite.models.entity.Town;
import com.example.webrestaurantsite.models.service.SeedCitiesServiceModel;
import com.example.webrestaurantsite.repository.TownRepository;
import com.example.webrestaurantsite.service.TownService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {
    private static final String PATH = "src/main/resources/static/all-cities/bg.json";
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;


    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper) {
        this.townRepository = townRepository;

        this.gson = gson;
        this.modelMapper = modelMapper;
    }


    @Override
    public void add() throws IOException {
        if (townRepository.count() != 0){
            return;
        }

        String fileContent = Files
                .readString(Path.of(PATH));

        SeedCitiesServiceModel[] seedCitiesServiceModels = gson.fromJson(fileContent, SeedCitiesServiceModel[].class);

        Arrays.stream(seedCitiesServiceModels).map(seedCitiesServiceModel -> {
            Town town = modelMapper.map(seedCitiesServiceModel, Town.class);
            return town;
        }).forEach(townRepository::save);
    }
}
