package pl.damian.wasik.spring.app.club.service.impl;

import org.springframework.stereotype.Service;
import pl.damian.wasik.spring.app.club.repository.ClubRepository;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;
import pl.damian.wasik.spring.app.club.service.ClubService;
import pl.damian.wasik.spring.app.club.web.model.Club;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<Club> findAllClubs() {
        List<ClubEntity> clubs = clubRepository.findAll();
        return clubs.stream().map((clubEntity) -> mapToClub(clubEntity)).collect(Collectors.toList());
    }

    private Club mapToClub(ClubEntity clubEntity) {
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
}
