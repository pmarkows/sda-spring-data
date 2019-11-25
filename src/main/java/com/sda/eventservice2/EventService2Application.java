package com.sda.eventservice2;

import com.sda.eventservice2.dao.EventRepository;
import com.sda.eventservice2.dao.LocationRepository;
import com.sda.eventservice2.dao.PersonRepository;
import com.sda.eventservice2.model.Event;
import com.sda.eventservice2.model.Location;
import com.sda.eventservice2.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.print.Book;
import java.time.LocalDate;

@SpringBootApplication
public class EventService2Application {

	public static void main(String[] args) {
		SpringApplication.run(EventService2Application.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(EventRepository eventRepository,
								   LocationRepository locationRepository,
								   PersonRepository personRepository) {
		return args -> {

			Location location1 = locationRepository.save(new Location("Kwadrat", "Rynek 29"));
			Location location2 = locationRepository.save(new Location("Sala konferencyjna 1", "ul. Lisa Kuli 19"));

			Person person1 = personRepository.save(new Person("Adam Kowalski", "adam@sda.pl"));
			Person person2 = personRepository.save(new Person("Jan Kowalski", "jan@sda.pl"));
			Person person3 = personRepository.save(new Person("Tomasz Nowak", "tomasz@sda.pl"));
			Person person4 = personRepository.save(new Person("Karol Nowak", "karol@sda.pl"));

			eventRepository.save(new Event("Kurs Java", LocalDate.now().plusWeeks(2), location1, person1));
		};
	}
}
