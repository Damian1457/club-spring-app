package pl.damian.wasik.spring.app.club.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;
import pl.damian.wasik.spring.app.club.web.model.Club;

import java.time.LocalDateTime;

@SpringBootTest
class ClubMapperTest {

    private static final String TITLE = "My Club";
    public static final String PHOTO_URL = "www.damian.pl";
    public static final String IMPORTANT_CLUB = "Club is the most important club";
    public static final LocalDateTime CREATED_ON = LocalDateTime.now();
    public static final LocalDateTime UPDATED_ON = LocalDateTime.now();

    @Autowired
    private ClubMapper clubMapper;

    @Test
    void givenClubEntity_whenMapToClub_thenReturnClub() {
        //Given
        ClubEntity club = ClubEntity.builder()
                .title(TITLE)
                .photoUrl(PHOTO_URL)
                .content(IMPORTANT_CLUB)
                .createdOn(CREATED_ON)
                .updatedOn(UPDATED_ON)
                .build();

        //When
        Club mapClub = clubMapper.mapToClub(club);

        //Then
        Assertions.assertNotNull(mapClub, "The mapClub is null");
    }
}