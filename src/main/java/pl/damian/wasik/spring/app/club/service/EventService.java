package pl.damian.wasik.spring.app.club.service;

import pl.damian.wasik.spring.app.club.web.model.Event;

import java.util.List;

public interface EventService {
    void create(Long id, Event event);

    List<Event> findAllEvents();
}
