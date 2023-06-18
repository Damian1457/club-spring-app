package pl.damian.wasik.spring.app.club.service.impl;

import org.springframework.stereotype.Service;
import pl.damian.wasik.spring.app.club.repository.ClubRepository;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;
import pl.damian.wasik.spring.app.club.service.ClubService;
import pl.damian.wasik.spring.app.club.mapper.ClubMapper;
import pl.damian.wasik.spring.app.club.web.model.Club;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;
    private ClubMapper clubMapper;

    public ClubServiceImpl(ClubRepository clubRepository, ClubMapper clubMapper) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
    }

    @Override
    public List<Club> findAllClubs() {
        List<ClubEntity> clubs = clubRepository.findAll();
        return clubs.stream().map(clubMapper::mapToClub).collect(Collectors.toList());
    }
}
