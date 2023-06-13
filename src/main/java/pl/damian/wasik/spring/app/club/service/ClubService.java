package pl.damian.wasik.spring.app.club.service;

import pl.damian.wasik.spring.app.club.web.model.Club;

import java.util.List;

public interface ClubService {
    List<Club> findAllClubs();
}
