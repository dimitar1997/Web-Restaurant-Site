package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.models.BidingModels.RegisterBidingModel;
import com.example.webrestaurantsite.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegisterController {
    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @PostMapping("/error-register")
    public String errorRegister(@Valid RegisterBidingModel registerBidingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors() || !registerBidingModel.getPassword().equals(registerBidingModel.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("registerBidingModel", registerBidingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.registerBidingModel", registerBidingModel);
            return "redirect/users/register";
        }
        userService.addUser(registerBidingModel);
        return "redirect:/";
    }
}