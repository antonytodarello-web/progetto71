package antoniotodarello.progetto70.controller;


import antoniotodarello.progetto70.authorization.EventService;
import antoniotodarello.progetto70.entities.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService service;
    @GetMapping
    public List<Event> getAllEvents() {
        return service.getAll();
    }
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return service.create(event);
    }
}
