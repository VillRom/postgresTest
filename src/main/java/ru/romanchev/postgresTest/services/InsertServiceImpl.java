package ru.romanchev.postgresTest.services;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.romanchev.postgresTest.data.ListsDates;
import ru.romanchev.postgresTest.model.Event;
import ru.romanchev.postgresTest.model.User;
import ru.romanchev.postgresTest.repository.EventRepository;
import ru.romanchev.postgresTest.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Data
@RequiredArgsConstructor
public class InsertServiceImpl implements InsertService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private Random random = new Random();
    private LinkedList<User> usersForEvents = new LinkedList<>();

    @Override
    @Transactional
    public void insertDb(Long countUsers, Long countEvents) {
        long partSizeUser = countUsers / 4;
        long partSizeEvent = countEvents / 6;
        CompletableFuture<?>[] futures = new CompletableFuture[4];

        for (int i = 0; i < 4; i++) {
            long start = i * partSizeUser;
            long end = (i == 3) ? countUsers : (i + 1) * partSizeUser;

            futures[i] = CompletableFuture.supplyAsync(() -> createdUsers(end - start))
                    .thenAcceptAsync(userRepository::saveAll);
        }

        for (int i = 0; i < 4; i++) {
            long start = i * partSizeEvent;
            long end = (i == 3) ? countEvents : (i + 1) * partSizeEvent;

            futures[i] = CompletableFuture.supplyAsync(() -> createdEvents(end - start))
                    .thenAcceptAsync(eventRepository::saveAll);
        }
    }

    private List<User> createdUsers(Long countUsers) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < countUsers; i++) {
            int r = random.nextInt(ListsDates.names.size());
            User user = new User();
            String name = ListsDates.names.get(r);
            user.setName(name);
            user.setNikname("nikname" + name);
            user.setNumber(random.nextLong(10000));
            users.add(user);
        }
        addUsersId(users);
        return users;
    }

    private void addUsersId(List<User> users) {
        for (int i = 0;i <= users.size(); i++) {
            if (usersForEvents.size() == 100) return;
            usersForEvents.add(users.get(i));
        }
    }

    private List<Event> createdEvents(Long countEvents) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i <= countEvents; i++) {
            Event event = new Event();
            int ran = random.nextInt(usersForEvents.size());
            User user = usersForEvents.get(ran);
            int r = random.nextInt(ListsDates.namesEvent.size());
            event.setNameEvent(ListsDates.namesEvent.get(r));
            event.setCreator(user);
            event.setStart(randomDateWithTime());
            events.add(event);
        }
        return events;
    }


    private LocalDateTime randomDateWithTime() {
        LocalDateTime startOfMonth = LocalDateTime.of(2025, Month.FEBRUARY, 1, 0, 0);
        LocalDateTime endOfMonth = startOfMonth.plusMonths(1).minusDays(1).withHour(23).withMinute(59).withSecond(59);

        long daysBetween = ChronoUnit.DAYS.between(startOfMonth.toLocalDate(), endOfMonth.toLocalDate()) + 1;
        long randomDay = ThreadLocalRandom.current().nextLong(daysBetween);

        return startOfMonth.plusDays(randomDay)
                .plusHours(ThreadLocalRandom.current().nextInt(0, 24))
                .plusMinutes(ThreadLocalRandom.current().nextInt(0, 60));
    }
}
