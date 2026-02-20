package antoniotodarello.progetto70.controller;

import antoniotodarello.progetto70.authorization.EventService;
import antoniotodarello.progetto70.entities.Event;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService service;

    @GetMapping
    public List<Event> all(){
        return service.getAll();
    }

    @PostMapping
    public Event create(@RequestBody Event event){
        return service.create(event);
    }
}
