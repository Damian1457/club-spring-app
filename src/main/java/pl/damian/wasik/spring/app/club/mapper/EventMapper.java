package pl.damian.wasik.spring.app.club.mapper;

import org.springframework.stereotype.Component;
import pl.damian.wasik.spring.app.club.repository.entity.EventEntity;
import pl.damian.wasik.spring.app.club.web.model.Event;

@Component
public class EventMapper {
    public static EventEntity mapToEventEntity(Event event) {
        EventEntity eventEntity = EventEntity.builder()
                .id(event.getId())
                .name(event.getName())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .type(event.getType())
                .photoUrl(event.getPhotoUrl())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .build();
        return eventEntity;
    }

    public static Event mapToEvent(EventEntity eventEntity) {
        Event event = Event.builder()
                .id(eventEntity.getId())
                .name(eventEntity.getName())
                .startTime(eventEntity.getStartTime())
                .endTime(eventEntity.getEndTime())
                .type(eventEntity.getType())
                .photoUrl(eventEntity.getPhotoUrl())
                .createdOn(eventEntity.getCreatedOn())
                .updatedOn(eventEntity.getUpdatedOn())
                .build();
        return event;
    }
}
