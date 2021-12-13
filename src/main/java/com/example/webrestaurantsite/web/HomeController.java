package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.service.impl.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(@AuthenticationPrincipal UserDetailsImpl user){
        if (user == null){
            return "index";
        }else {
            return "home";
        }

    }
}
