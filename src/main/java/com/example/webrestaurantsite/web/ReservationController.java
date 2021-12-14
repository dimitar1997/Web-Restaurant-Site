package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.models.BidingModels.ReserveBidingModel;
import com.example.webrestaurantsite.models.entity.Reservation;
import com.example.webrestaurantsite.service.ReservationService;
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
import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("my-reservations")
    public String currentUserReservations(@AuthenticationPrincipal UserDetailsImpl currentUser,
                                          Model model) {
        List<Reservation> allCurrentUserReservations = reservationService.allCurrentUserReservations(currentUser);
        model.addAttribute("allCurrentUserReservations",allCurrentUserReservations);
        return "my-reservations";
    }

    @PostMapping("/booked/{restaurantId}")
    public String bookDate(@PathVariable Long restaurantId, @Valid ReserveBidingModel reserveBidingModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetailsImpl currentUser) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("reserveBidingModel", reserveBidingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.reserveBidingModel", bindingResult);
            return "redirect:/restaurant/" + restaurantId + "/details";
        }
        reservationService.makeReserve(restaurantId, currentUser, reserveBidingModel);
        return "my-reservations";
    }
}
