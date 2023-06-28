package pl.damian.wasik.spring.app.club.service.impl;

import org.springframework.stereotype.Service;
import pl.damian.wasik.spring.app.club.repository.ClubRepository;
import pl.damian.wasik.spring.app.club.repository.EventRepository;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;
import pl.damian.wasik.spring.app.club.repository.entity.EventEntity;
import pl.damian.wasik.spring.app.club.service.EventService;
import pl.damian.wasik.spring.app.club.web.model.Event;

import java.util.List;
import java.util.stream.Collectors;

import static pl.damian.wasik.spring.app.club.mapper.EventMapper.mapToEvent;
import static pl.damian.wasik.spring.app.club.mapper.EventMapper.mapToEventEntity;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public List<Event> findAllEvents() {
        List<EventEntity> events = eventRepository.findAll();
        return events.stream().map(eventEntity -> mapToEvent(eventEntity)).collect(Collectors.toList());
    }

    @Override
    public Event findByEventId(Long id) {
        EventEntity eventEntity = eventRepository.findById(id).get();
        return mapToEvent(eventEntity);
    }

    @Override
    public void update(Event event) {
        EventEntity eventEntity = mapToEventEntity(event);
        eventRepository.save(eventEntity);
    }

    @Override
    public void create(Long id, Event event) {
        ClubEntity clubEntity = clubRepository.findById(id).get();
        EventEntity eventEntity = mapToEventEntity(event);
        eventEntity.setClubEntity(clubEntity);
        eventRepository.save(eventEntity);
    }
}
