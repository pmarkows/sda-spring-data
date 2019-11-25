package com.sda.eventservice2.dao;

import com.sda.eventservice2.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
