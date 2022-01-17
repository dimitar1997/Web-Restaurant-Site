package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.models.BidingModels.ReserveBidingModel;
import com.example.webrestaurantsite.models.entity.Reservation;
import com.example.webrestaurantsite.models.view.ReservationCustomViewModel;
import com.example.webrestaurantsite.models.view.ReservationViewDetailsModel;
import com.example.webrestaurantsite.service.ReservationService;
import com.example.webrestaurantsite.service.RestaurantService;
import com.example.webrestaurantsite.service.impl.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final RestaurantService restaurantService;

    public ReservationController(ReservationService reservationService, RestaurantService restaurantService) {
        this.reservationService = reservationService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/my-reservations")
    public String currentUserReservations(@AuthenticationPrincipal UserDetailsImpl currentUser,
                                          Model model) {
        List<ReservationCustomViewModel> allCurrentUserReservations = reservationService.allCurrentUserReservations(currentUser);
        model.addAttribute("allCurrentUserReservations", allCurrentUserReservations);
        return "my-reservations";
    }

    @PostMapping("/booked/{restaurantId}")
    public String bookDate(@PathVariable Long restaurantId, @Valid ReserveBidingModel reserveBidingModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetailsImpl currentUser) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("reserveBidingModel", reserveBidingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.reserveBidingModel", bindingResult);
            return "redirect:/restaurant/details/" + restaurantId;
        }
        reserveBidingModel.setRestaurantId(restaurantId);
        reservationService.makeReserve(currentUser, reserveBidingModel);
        return "redirect:/reservation/my-reservations";
    }

    @GetMapping("/my-reservations-details/{reservationId}")
    public String detailsMyReservations(@PathVariable Long reservationId,
                                        Model model) {
        ReservationViewDetailsModel reservationViewDetailsModel = reservationService.findDetailReservation(reservationId);
        model.addAttribute("reservationViewDetailsModel", reservationViewDetailsModel);

        return "my-reservation-details";
    }
    @PostMapping("/cancel/{reservationId}")
    public String cancelReservation(@PathVariable Long reservationId){
        reservationService.cancelReservation(reservationId);
        return "redirect:/reservation/my-reservations";
    }

}
