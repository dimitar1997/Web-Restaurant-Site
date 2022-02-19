package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.models.BidingModels.*;
import com.example.webrestaurantsite.models.service.RestaurantUpdateServiceModel;
import com.example.webrestaurantsite.models.view.ListOfPeopleViewModel;
import com.example.webrestaurantsite.models.view.RestaurantArticleViewModel;
import com.example.webrestaurantsite.models.view.RestaurantViewDetailsModel;
import com.example.webrestaurantsite.service.ReservationService;
import com.example.webrestaurantsite.service.RestaurantService;
import com.example.webrestaurantsite.service.StatService;
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
    private final ModelMapper modelMapper;
    private final ReservationService reservationService;
    private final StatService statService;

    public RestaurantController(RestaurantService restaurantService, TownService townService, ModelMapper modelMapper, ReservationService reservationService, StatService statService) {
        this.restaurantService = restaurantService;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.reservationService = reservationService;
        this.statService = statService;
    }

    @GetMapping("my-places")
    public String myAddedPlaces(@AuthenticationPrincipal UserDetailsImpl currentUser, Model model) {
        List<RestaurantArticleViewModel> restaurantArticleViewModels = restaurantService.allRestaurant(currentUser);
        model.addAttribute("restaurantArticleViewModels", restaurantArticleViewModels);
        return "my-places";
    }


    @GetMapping("/details/{restaurantId}")
    public String detailsRestaurant(@PathVariable Long restaurantId,
                                    Model model, @AuthenticationPrincipal UserDetailsImpl currentUser, ReserveBidingModel reserveBidingModel) {
        statService.clear();
        statService.onRequest(restaurantId);
        RestaurantViewDetailsModel restaurantViewDetailsModel = restaurantService.details(restaurantId);
        model.addAttribute("isOwner", restaurantService.isOwner(currentUser.getUsername(), restaurantId));
        model.addAttribute("restaurantViewDetailsModel", restaurantViewDetailsModel);
        model.addAttribute("reserveBidingModel", reserveBidingModel);
        model.addAttribute("detailsEntries", statService.getStats());

        return "restaurant-details";
    }


    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("addRestaurantBidingModel") && !model.containsAttribute("addPictureBidingModel")) {
            model.addAttribute("addRestaurantBidingModel", new AddRestaurantBidingModel())
                    .addAttribute("addPictureBidingModel", new AddPictureBidingModel())
                    .addAttribute("allTowns", townService.getAllTowns());
        }
        return "add-restaurant";
    }

    @PostMapping("/add")
    public String errorAdd(@Valid AddRestaurantBidingModel addRestaurantBidingModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           @Valid AddPictureBidingModel addPictureBidingModel,
                           @AuthenticationPrincipal UserDetailsImpl currentUser) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addRestaurantBidingModel", addRestaurantBidingModel)
                    .addFlashAttribute("addPictureBidingModel", addPictureBidingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addRestaurantBidingModel", bindingResult)
                    .addFlashAttribute("allTowns", townService.getAllTowns());
            return "redirect:/restaurant/add";
        }
        restaurantService.addRestaurant(addRestaurantBidingModel, currentUser, addPictureBidingModel);
        return "redirect:/";
    }

    @PreAuthorize("@restaurantServiceImpl.isOwner(#principal.name, #id)")
    @DeleteMapping("/delete/{id}")
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

    @GetMapping("/check-by-date/{restaurantId}")
    public String checkByDate(@PathVariable Long restaurantId, Model model) {
        model.addAttribute("currentId", restaurantId);
        return "check-by-dates";
    }

    @PostMapping("/check-by-date/{restaurantId}")
    public String checkByDate(@PathVariable Long restaurantId, @Valid CheckByDateBidingModel checkByDateBidingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("checkByDateBidingModel", checkByDateBidingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.checkByDateBidingModel", bindingResult);
            return "redirect:/restaurant/check-by-date/" + restaurantId;
        }

        return "redirect:/restaurant/list-of-people-restaurant-reservation/" + restaurantId;
    }

    @GetMapping("/list-of-people-restaurant-reservation/{restaurantId}")
    public String listOfPeople(@PathVariable Long restaurantId, Model model) {
        List<ListOfPeopleViewModel> listOfPeopleViewModels = reservationService.loadListOfPeople(restaurantId);
        model.addAttribute("listOfPeopleViewModels", listOfPeopleViewModels);
        return "list-of-people";
    }
    @PostMapping("/restaurants-by-town")
    public String restaurantByTownSearch(@Valid SearchByTownName searchByTownName, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("searchByTownName", searchByTownName)
                    .addFlashAttribute("org.springframework.validation.BindingResult.searchByTownName", bindingResult)
                    .addFlashAttribute("allTowns", townService.getAllTowns());
        }
        model.addAttribute("restaurantArticleViewModels", restaurantService.findAllRestuarantsByTown(searchByTownName.getCity()));


        return "find-by-town";
    }

    @ModelAttribute
    public SearchByTownName searchByTownName() {
        return new SearchByTownName();
    }

    @ModelAttribute
    public CheckByDateBidingModel checkByDateBidingModel() {
        return new CheckByDateBidingModel();
    }


}
