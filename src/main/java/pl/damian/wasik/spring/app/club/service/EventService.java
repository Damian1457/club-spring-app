package pl.damian.wasik.spring.app.club.service;

import pl.damian.wasik.spring.app.club.web.model.Event;

public interface EventService {
    void create(Long id, Event event);
}
