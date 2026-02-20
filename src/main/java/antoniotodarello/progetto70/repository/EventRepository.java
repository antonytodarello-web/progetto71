package antoniotodarello.progetto70.repository;

import antoniotodarello.progetto70.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
