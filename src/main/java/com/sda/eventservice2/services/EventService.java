package com.sda.eventservice2.services;

import com.sda.eventservice2.dao.EventRepository;
import com.sda.eventservice2.model.Event;
import com.sda.eventservice2.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;
    private PersonService personService;

    public EventService(EventRepository eventRepository,
                        PersonService personService) {
        this.eventRepository = eventRepository;
        this.personService = personService;
    }

    public Event getEventById(Long id) throws EventNotFoundException {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Could not find Event with id: " + id));
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createNewEvent(Event event) throws PersonNotFoundException {
        Person organizer = personService.getPersonById(event.getOrganizer().getId());
        event.setOrganizer(organizer);
        return eventRepository.save(event);
    }
}
