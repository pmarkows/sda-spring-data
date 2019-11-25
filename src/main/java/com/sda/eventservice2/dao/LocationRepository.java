package com.sda.eventservice2.dao;

import com.sda.eventservice2.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
