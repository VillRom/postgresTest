package ru.romanchev.postgresTest.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameEvent;
    @ManyToOne
    private User creator;
    private LocalDateTime start;
}
