package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.models.BidingModels.TownBidingModel;
import com.example.webrestaurantsite.models.view.AllTownsViewModel;
import com.example.webrestaurantsite.service.TownService;
import com.example.webrestaurantsite.service.impl.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
