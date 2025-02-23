package ru.romanchev.postgresTest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.romanchev.postgresTest.model.User;


public interface UserRepository extends CrudRepository<User, Long> {

    //@Query("select User from User order by RANDOM() limit 1")
    @Query("select u from User u order by random() limit 1")
    User randomUser();
}
