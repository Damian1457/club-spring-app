package pl.damian.wasik.spring.app.club.service.impl;

import org.springframework.stereotype.Service;
import pl.damian.wasik.spring.app.club.mapper.EventMapper;
import pl.damian.wasik.spring.app.club.repository.ClubRepository;
import pl.damian.wasik.spring.app.club.repository.EventRepository;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;
import pl.damian.wasik.spring.app.club.repository.entity.EventEntity;
import pl.damian.wasik.spring.app.club.service.EventService;
import pl.damian.wasik.spring.app.club.web.model.Event;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;
    private EventMapper eventMapper;

    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public void create(Long id, Event event) {
        ClubEntity clubEntity = clubRepository.findById(id).get();
        EventEntity eventEntity = eventMapper.mapToEventEntity(event);
        eventEntity.setClubEntity(clubEntity);
        eventRepository.save(eventEntity);
    }
}
