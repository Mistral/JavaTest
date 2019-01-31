package com.example.fluentApi;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShowManager {

    public Optional<List<Show>> getShows(Venue v, LocalDateTime dateTime) {
        List<Show> shows = v.getShows()
                            .stream()
                            .filter(show -> show.getEvents()
                                                .stream()
                                                .anyMatch(event -> event.isInTheSameDay(dateTime)))
                            .map(show -> Show.create(show.getShowName(),
                                                     show.getEvents()
                                                         .stream()
                                                         .filter(event -> event.isInTheSameDay(dateTime))
                                                         .collect(Collectors.toList())))
                            .limit(5)
                            .collect(Collectors.toList());

        if (shows.size() != 0) {
            return Optional.of(shows);
        }
        else {
            return Optional.empty();
        }
    }

}
