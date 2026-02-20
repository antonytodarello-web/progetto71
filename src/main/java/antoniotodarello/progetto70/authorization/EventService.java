package antoniotodarello.progetto70.authorization;


import antoniotodarello.progetto70.entities.Event;
import antoniotodarello.progetto70.entities.User;
import antoniotodarello.progetto70.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository repo;

    public Event create(Event event){
        return repo.save(event);
    }

    public List<Event> getAll(){
        return repo.findAll();
    }

    public Event update(Long id, Event updated, User user){
        Event event = repo.findById(id).orElseThrow();

        if(!event.getCreator().getId().equals(user.getId()))
            throw new RuntimeException("Non autorizzato");

        event.setTitle(updated.getTitle());
        event.setDescription(updated.getDescription());
        event.setDate(updated.getDate());
        event.setLocation(updated.getLocation());
        event.setAvailableSeats(updated.getAvailableSeats());

        return repo.save(event);
    }

    public void delete(Long id, User user){
        Event event = repo.findById(id).orElseThrow();

        if(!event.getCreator().getId().equals(user.getId()))
            throw new RuntimeException("Non autorizzato");

        repo.delete(event);
    }
}
