package com.example.webrestaurantsite.web;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/users")
public class UserLoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login-error")
    public String errorLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
                             RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("bad_credential", true)
                .addFlashAttribute("username", username);
        return "redirect:/users/login";
    }
}
