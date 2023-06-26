package pl.damian.wasik.spring.app.club.mapper;

import org.springframework.stereotype.Component;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;
import pl.damian.wasik.spring.app.club.web.model.Club;

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
