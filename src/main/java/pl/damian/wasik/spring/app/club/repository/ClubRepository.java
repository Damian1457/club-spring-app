package pl.damian.wasik.spring.app.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<ClubEntity, Long> {
    Optional<ClubEntity> findByTitle(String url);

    @Query("SELECT c FROM ClubEntity c WHERE c.title LIKE CONCAT('%', :query, '%')")
    List<ClubEntity> readClubs(String query);
}
