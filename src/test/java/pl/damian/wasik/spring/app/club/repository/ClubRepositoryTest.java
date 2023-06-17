package pl.damian.wasik.spring.app.club.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ClubRepositoryTest {

    private static final String TITLE = "My Club";
    public static final String PHOTO_URL = "www.damian.pl";
    public static final String IMPORTANT_CLUB = "Club is the most important club";
    public static final LocalDateTime CREATED_ON = LocalDateTime.now();
    public static final LocalDateTime UPDATED_ON = LocalDateTime.now();

    @Autowired
    private ClubRepository clubRepository;

    @BeforeEach
    public void setUp() {
        clubRepository.deleteAll();
    }

    @Test
    void givenClubRepository_whenCheckingForData_thenDatabaseIsEmpty() {
        //Given
        //When
        List<ClubEntity> clubs = clubRepository.findAll();

        //Then
        Assertions.assertTrue(clubs.isEmpty(), "Database is not empty");
    }

    @Test
    void givenClubRepository_whenSaveAll_thenReturnSavedClub() {
        //Given
        ClubEntity club = ClubEntity.builder()
                .title(TITLE)
                .photoUrl(PHOTO_URL)
                .content(IMPORTANT_CLUB)
                .createdOn(CREATED_ON)
                .updatedOn(UPDATED_ON)
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