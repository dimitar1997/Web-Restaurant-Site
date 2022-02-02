package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.models.view.AllTownsViewModel;
import com.example.webrestaurantsite.service.TownService;
import com.example.webrestaurantsite.service.impl.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;



import java.util.List;

@Controller
public class HomeController {
    private final TownService townService;

    public HomeController(TownService townService) {
        this.townService = townService;
    }

    @GetMapping("/")
    public String homePage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        if (user == null) {
            return "index";
        } else {
            List<AllTownsViewModel> allTownsViewModels = townService.getAllTowns();
            model.addAttribute("allTowns", allTownsViewModels);
            return "home";
        }

    }

}
