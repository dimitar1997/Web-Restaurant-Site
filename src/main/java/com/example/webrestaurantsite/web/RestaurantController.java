package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.models.BidingModels.AddPictureBidingModel;
import com.example.webrestaurantsite.models.BidingModels.AddRestaurantBidingModel;
import com.example.webrestaurantsite.models.BidingModels.RestaurantUpdateBidingModel;
import com.example.webrestaurantsite.models.service.RestaurantUpdateServiceModel;
import com.example.webrestaurantsite.models.view.AllTownsViewModel;
import com.example.webrestaurantsite.models.view.RestaurantArticleViewModel;
import com.example.webrestaurantsite.models.view.RestaurantViewDetailsModel;
import com.example.webrestaurantsite.service.PictureService;
import com.example.webrestaurantsite.service.RestaurantService;
import com.example.webrestaurantsite.service.TownService;
import com.example.webrestaurantsite.service.impl.UserDetailsImpl;
import org.modelmapper.ModelMapper;
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
import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final TownService townService;
    private final PictureService pictureService;
private final ModelMapper modelMapper;
    public RestaurantController(RestaurantService restaurantService, TownService townService, PictureService pictureService, ModelMapper modelMapper) {
        this.restaurantService = restaurantService;
        this.townService = townService;
        this.pictureService = pictureService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("my-places")
    public String myAddedPlaces(@AuthenticationPrincipal UserDetailsImpl currentUser, Model model) {
        List<RestaurantArticleViewModel> restaurantArticleViewModels = restaurantService.allRestaurant(currentUser);
        model.addAttribute("restaurantArticleViewModels", restaurantArticleViewModels);
        return "my-places";
    }


    @GetMapping("/details/{restaurantId}")
    public String detailsRestaurant(@PathVariable Long restaurantId,
                                    Model model) {
        RestaurantViewDetailsModel restaurantViewDetailsModel = restaurantService.details(restaurantId);
        model.addAttribute("restaurantViewDetailsModel", restaurantViewDetailsModel);

        return "restaurant-details";
    }

    @GetMapping("/add")
    public String add(Model model) {

        List<AllTownsViewModel> allTownsViewModels = townService.getAllTowns();
        model.addAttribute("allTowns", allTownsViewModels);
        return "add-restaurant";
    }

    @PostMapping(value = "/add")
    public String add(@Valid AddRestaurantBidingModel addRestaurantBidingModel, AddPictureBidingModel addPictureBidingModel,
                      BindingResult bindingResult, RedirectAttributes redirectAttributes,
                      @AuthenticationPrincipal UserDetailsImpl currentUser) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addRestaurantBidingModel", addRestaurantBidingModel)
                    .addFlashAttribute("addPictureBidingModel", addPictureBidingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addRestaurantBidingModel", bindingResult);
            return "redirect:/add";
        }
        restaurantService.addRestaurant(addRestaurantBidingModel, currentUser, addPictureBidingModel);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("@restaurantServiceImpl.isOwner(#principal.name, #id)")
    public String deleteRestaurant(@PathVariable Long id, Principal principal) {
        restaurantService.delete(id);
        return "redirect:/";
    }


    @GetMapping("/update/{updateId}")
    public String updateRestaurant(@PathVariable Long updateId, Model model) {

        RestaurantViewDetailsModel restaurantViewDetailsModel = restaurantService.findRestaurantById(updateId);
        model.addAttribute("restaurantViewDetailsModel", restaurantViewDetailsModel);
        return "update";
    }

    @PostMapping("/update/{updateId}")
    public String updateRestaurant(@PathVariable Long updateId, @Valid RestaurantUpdateBidingModel restaurantUpdateBidingModel,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("restaurantUpdateBidingModel", restaurantUpdateBidingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.restaurantUpdateBidingModel", bindingResult);

            return "redirect:/restaurant/update/" + updateId;
        }
        RestaurantUpdateServiceModel restaurantUpdateServiceModel = modelMapper.map(restaurantUpdateBidingModel, RestaurantUpdateServiceModel.class);
        restaurantUpdateServiceModel.setId(updateId);
        restaurantService.update(restaurantUpdateServiceModel);
        return "redirect:/restaurant/details/" + updateId;
    }


    @ModelAttribute
    public AddRestaurantBidingModel addRestaurantBidingModel() {
        return new AddRestaurantBidingModel();
    }

    @ModelAttribute
    public AddPictureBidingModel addPictureBidingModel() {
        return new AddPictureBidingModel();
    }

}
