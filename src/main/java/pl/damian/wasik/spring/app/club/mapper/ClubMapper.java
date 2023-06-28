package pl.damian.wasik.spring.app.club.mapper;

import org.springframework.stereotype.Component;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;
import pl.damian.wasik.spring.app.club.web.model.Club;

import java.util.stream.Collectors;

import static pl.damian.wasik.spring.app.club.mapper.EventMapper.mapToEvent;

@Component
public class ClubMapper {
    public static Club mapToClub(ClubEntity clubEntity) {
        Club club = Club.builder()
                .id(clubEntity.getId())
                .title(clubEntity.getTitle())
                .photoUrl(clubEntity.getPhotoUrl())
                .content(clubEntity.getContent())
                .createdOn(clubEntity.getCreatedOn())
                .updatedOn(clubEntity.getUpdatedOn())
                .events(clubEntity.getEvents().stream().map((eventEntity) -> mapToEvent(eventEntity)).collect(Collectors.toList()))
                .build();
        return club;
    }

    public static ClubEntity mapToClubEntity(Club club) {
        ClubEntity clubEntity = ClubEntity.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return clubEntity;
    }
}
