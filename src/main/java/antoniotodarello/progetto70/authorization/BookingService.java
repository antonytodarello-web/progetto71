package antoniotodarello.progetto70.authorization;


import antoniotodarello.progetto70.entities.Booking;
import antoniotodarello.progetto70.entities.Event;
import antoniotodarello.progetto70.entities.User;
import antoniotodarello.progetto70.repository.BookingRepository;
import antoniotodarello.progetto70.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepo;
    private final EventRepository eventRepo;

    public Booking book(Long eventId, int seats, User user){

        Event event = eventRepo.findById(eventId).orElseThrow();

        if(event.getAvailableSeats() < seats)
            throw new RuntimeException("Posti insufficienti");

        event.setAvailableSeats(event.getAvailableSeats() - seats);

        Booking booking = Booking.builder()
                .event(event)
                .user(user)
                .seatsReserved(seats)
                .build();

        eventRepo.save(event);
        return bookingRepo.save(booking);
    }
}
