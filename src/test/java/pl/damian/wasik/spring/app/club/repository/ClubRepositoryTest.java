package pl.damian.wasik.spring.app.club.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;

import java.time.LocalDateTime;

@SpringBootTest
class ClubRepositoryTest {

    @Autowired
    private ClubRepository clubRepository;

    @Test
    void givenClubRepository_whenSaveAll_thenReturnSavedClub() {
        //Given
        ClubEntity club = ClubEntity.builder()
                .title("My Club")
                .photoUrl("www.damian.pl")
                .content("Club is the most important club")
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        //When
        ClubEntity savedClubEntity = clubRepository.save(club);

        //Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedClubEntity.getContent(), "Saved club entity is null"),
                () -> Assertions.assertEquals(club.getPhotoUrl(), savedClubEntity.getPhotoUrl(), "Urls isn't the same")
        );
    }
}