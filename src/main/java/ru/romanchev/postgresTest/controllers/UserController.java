package ru.romanchev.postgresTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.romanchev.postgresTest.model.Event;
import ru.romanchev.postgresTest.model.User;
import ru.romanchev.postgresTest.repository.EventRepository;
import ru.romanchev.postgresTest.repository.UserRepository;
import ru.romanchev.postgresTest.services.InsertService;

@RestController
public class UserController {
    private final UserRepository userRepository;

    private final EventRepository eventRepository;
    private final InsertService insertService;
    @Autowired
    public UserController(InsertService insertService, UserRepository userRepository,
                          EventRepository eventRepository) {
        this.insertService = insertService;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }
    @GetMapping("/fillingdb/{count}")
    public void getUsers(@PathVariable Long count) {
        Long countEvents = count * 3;
        insertService.insertDb(count, countEvents);
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/events")
    public Iterable<Event> getEvents() {
        return eventRepository.findAll();
    }
}
