package com.sda.eventservice2.api;

import com.sda.eventservice2.model.Event;
import com.sda.eventservice2.services.EventNotFoundException;
import com.sda.eventservice2.services.EventService;
import com.sda.eventservice2.services.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class EventsController {

    private EventService eventService;

    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() throws EventNotFoundException {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/events/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable Long eventId) throws EventNotFoundException {
        return ResponseEntity.ok(eventService.getEventById(eventId));
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createNewEvent(@Valid @RequestBody Event event) throws PersonNotFoundException {
        return new ResponseEntity(eventService.createNewEvent(event), HttpStatus.CREATED);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleEventNotFoundException(EventNotFoundException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
