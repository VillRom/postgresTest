package ru.romanchev.postgresTest;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.romanchev.postgresTest.model.Event;
import ru.romanchev.postgresTest.model.User;
import ru.romanchev.postgresTest.repository.EventRepository;
import ru.romanchev.postgresTest.repository.UserRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class PostgresTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresTestApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(UserRepository userRepo, EventRepository eventRepo) {
		return args -> {
			User user = new User();
			user.setName("name");
			user.setNikname("nik");
			user.setNumber(4586L);
			userRepo.save(user);

			Event event = new Event();
			event.setNameEvent("nameEvent");
			event.setCreator(user);
			event.setStart(LocalDateTime.now());
			eventRepo.save(event);
		};
	}
}
