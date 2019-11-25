package com.sda.eventservice2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String name;
    @NotNull
    private LocalDate startDate;
    @ManyToOne
    private Location location;
    @ManyToOne
    private Person organizer;
    @ManyToMany
    private List<Person> attendees;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Person organizer) {
        this.organizer = organizer;
    }

    public List<Person> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Person> attendees) {
        this.attendees = attendees;
    }

    public Event() {
    }

    public Event(String name, LocalDate startDate, Location location, Person organizer) {
        this.name = name;
        this.startDate = startDate;
        this.location = location;
        this.organizer = organizer;
    }
}
