package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.service.TownService;
import com.example.webrestaurantsite.service.impl.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/town-picture")
public class TownAndPictureController {
    private final TownService townService;

    public TownAndPictureController(TownService townService) {
        this.townService = townService;
    }

    @GetMapping("/add-town")
    public String addTown(){
        return "add-town";
    }
    @PostMapping("/add-town")
    public  String addTown(String townName, @AuthenticationPrincipal UserDetailsImpl currentUser){
        townService.add(townName, currentUser);
        return "add-picture";
    }

}
