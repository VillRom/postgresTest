package ru.romanchev.postgresTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romanchev.postgresTest.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
