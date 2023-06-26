package pl.damian.wasik.spring.app.club.service.impl;

import org.springframework.stereotype.Service;
import pl.damian.wasik.spring.app.club.repository.ClubRepository;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;
import pl.damian.wasik.spring.app.club.service.ClubService;
import pl.damian.wasik.spring.app.club.mapper.ClubMapper;
import pl.damian.wasik.spring.app.club.web.model.Club;

import java.util.List;
import java.util.stream.Collectors;

import static pl.damian.wasik.spring.app.club.mapper.ClubMapper.mapToClub;
import static pl.damian.wasik.spring.app.club.mapper.ClubMapper.mapToClubEntity;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<Club> findAllClubs() {
        List<ClubEntity> clubs = clubRepository.findAll();
        return clubs.stream().map(club -> mapToClub(club)).collect(Collectors.toList());
    }

    @Override
    public ClubEntity create(Club club) {
        ClubEntity clubEntity = mapToClubEntity(club);
        return clubRepository.save(clubEntity);
    }

    @Override
    public Club read(Long id) {
        ClubEntity clubEntity = clubRepository.findById(id).get();
        return mapToClub(clubEntity);
    }

    @Override
    public void update(Club club) {
        ClubEntity clubEntity = mapToClubEntity(club);
        clubRepository.save(clubEntity);
    }

    @Override
    public void delete(Long id) {
        clubRepository.deleteById(id);
    }

    @Override
    public List<Club> readClubs(String query) {
        List<ClubEntity> clubs = clubRepository.readClubs(query);
        return clubs.stream().map(club -> mapToClub(club)).collect(Collectors.toList());
    }
}
