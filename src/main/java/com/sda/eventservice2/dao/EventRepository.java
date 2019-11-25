package com.sda.eventservice2.dao;

import com.sda.eventservice2.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> getEventsByOrganizerName(String organizerName);
}
