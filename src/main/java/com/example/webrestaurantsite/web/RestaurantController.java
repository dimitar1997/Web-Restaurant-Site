package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.models.BidingModels.AddRestaurantBidingModel;
import com.example.webrestaurantsite.models.view.RestaurantViewDetailsModel;
import com.example.webrestaurantsite.service.RestaurantService;
import com.example.webrestaurantsite.service.impl.UserDetailsImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping("/details/{restaurantId}")
    public String detailsRestaurant(@PathVariable Long restaurantId,
                                    Model model) {
        RestaurantViewDetailsModel restaurantViewDetailsModel = restaurantService.details(restaurantId);
        model.addAttribute("restaurantViewDetailsModel", restaurantViewDetailsModel);

        return "restaurant-details";
    }
    @GetMapping("/add")
    public String add(){
        return "add-restaurant";
    }

    @PostMapping("/add")
    public String add(@Valid AddRestaurantBidingModel addRestaurantBidingModel,
                      BindingResult bindingResult, RedirectAttributes redirectAttributes,
                      @AuthenticationPrincipal UserDetailsImpl currentUser) throws IOException {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addRestaurantBidingModel", addRestaurantBidingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addRestaurantBidingModel", bindingResult);
            return "redirect:/add";
        }
        restaurantService.addRestaurant(addRestaurantBidingModel, currentUser);
        return "redirect:/";
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("@restaurantServiceImpl.isOwner(#principal.name, #id)")
    public String deleteRestaurant(@PathVariable Long id, Principal principal){
        restaurantService.delete(id);
        return  "redirect:/";
    }

}
