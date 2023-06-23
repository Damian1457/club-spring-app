package pl.damian.wasik.spring.app.club.service;

import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;
import pl.damian.wasik.spring.app.club.web.model.Club;

import java.util.List;

public interface ClubService {
    List<Club> findAllClubs();

    ClubEntity create(Club club);

    Club read(Long id);

    void update(Club club);

    void delete(Long id);
}
