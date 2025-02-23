package ru.romanchev.postgresTest.data;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListsDates {

    public static List<String> names = List.of("Anna", "Alexey", "Ivan", "Olga", "Maria", "Sergey",
            "Natalia", "Dmitry", "Elena", "Viktor", "Tatyana", "Mikhail", "Irina", "Andrey", "Ekaterina", "Vladimir",
            "Yulia", "Leonid", "Tamara", "Nikolay", "Anastasia", "Pavel", "Lyudmila", "Konstantin", "Valeria",
            "Denis", "Kseniya", "Igor", "Galina", "Anton", "Zoya", "Artem", "Larisa", "Maxim", "Vera", "Boris",
            "Lidia", "Vasily", "Polina", "Grigory", "Alina", "Evgeny", "Nadezhda", "Roman", "Inna", "Lev",
            "Valentina", "Stanislav", "Sofia", "Timofey", "Zinaida", "Kirill", "Nina", "Fyodor", "Elizaveta",
            "Georgy", "Margarita", "Pyotr", "Zhanna", "Ilya", "Rostislav", "Yevgeniya", "Aleksandr", "Svetlana",
            "Matvey", "Varvara", "Mark", "Lilia", "Arseniy", "Ulyana", "Eduard", "Angelina", "Yaroslav", "Darya",
            "Vitaly", "Tatiana");

    public static List<String> namesEvent = List.of("FIFA World Cup", "Olympic Games", "NBA Finals",
            "Wimbledon Championships", "Tour de France", "UEFA Champions League", "Super Bowl",
            "Formula One Grand Prix", "Rugby World Cup", "US Open Tennis", "The Masters Golf Tournament",
            "Boston Marathon", "Cricket World Cup", "World Chess Championship", "Ice Hockey World Championship",
            "Dakar Rally", "Ryder Cup");
}
