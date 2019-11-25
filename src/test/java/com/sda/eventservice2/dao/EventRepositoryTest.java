package com.sda.eventservice2.dao;

import com.sda.eventservice2.model.Event;
import com.sda.eventservice2.model.Location;
import com.sda.eventservice2.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    @Transactional
    public void testCreateNewEvent() {
        assertEquals(1, eventRepository.findAll().size());

        Location location = locationRepository.save(new Location("Gdzies tam", "ul. Kiepska"));
        Person organizer = personRepository.save(new Person("Janusz Szmidt", "janusz@com.pl"));
        Event event = new Event("Kurs Spring", LocalDate.now().plusWeeks(1), location, organizer);

        Event savedEvent = eventRepository.save(event);
        assertNotNull(savedEvent);

        assertEquals(2, eventRepository.findAll().size());

        assertEquals(1, eventRepository.getEventsByOrganizerName("Janusz Szmidt").size());
    }

}