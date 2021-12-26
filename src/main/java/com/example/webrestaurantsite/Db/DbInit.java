package com.example.webrestaurantsite.Db;

import com.example.webrestaurantsite.service.TownService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner {
    private final TownService townService;

    public DbInit(TownService townService) {
        this.townService = townService;
    }

    @Override
    public void run(String... args) throws Exception {
        townService.add();
    }
}
