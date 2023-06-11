package pl.damian.wasik.spring.app.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;

@Repository
public interface ClubRepository extends JpaRepository<ClubEntity, Long> {
}
