package antoniotodarello.progetto70.controller;

import antoniotodarello.progetto70.authorization.BookingService;
import antoniotodarello.progetto70.entities.Booking;
import antoniotodarello.progetto70.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService service;

    @PostMapping("/{eventId}")
    public Booking book(@PathVariable Long eventId,
                        @RequestParam int seats,
                        @AuthenticationPrincipal User user){
        return service.book(eventId, seats, user);
    }
}
