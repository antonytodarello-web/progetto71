package antoniotodarello.progetto70.repository;


import antoniotodarello.progetto70.entities.Booking;
import antoniotodarello.progetto70.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
}
