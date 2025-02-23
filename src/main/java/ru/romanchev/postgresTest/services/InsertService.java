package ru.romanchev.postgresTest.services;

import ru.romanchev.postgresTest.model.Event;
import ru.romanchev.postgresTest.model.User;

import java.util.List;

public interface InsertService {
    void insertDb(Long countUsers, Long countEvents);
}
