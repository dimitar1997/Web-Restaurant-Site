package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.models.BidingModels.AddRestaurantBidingModel;
import com.example.webrestaurantsite.models.view.RestaurantViewDetailsModel;
import com.example.webrestaurantsite.service.RestaurantService;
import com.example.webrestaurantsite.service.impl.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping("/{restaurantId}/details")
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
                      @AuthenticationPrincipal UserDetailsImpl currentUser){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addRestaurantBidingModel", addRestaurantBidingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addRestaurantBidingModel", bindingResult);
            return "redirect:/add";
        }
        restaurantService.addRestaurant(addRestaurantBidingModel, currentUser);
        return "redirect:/";
    }

}
