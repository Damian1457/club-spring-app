package pl.damian.wasik.spring.app.club.service;

import pl.damian.wasik.spring.app.club.repository.entity.UserEntity;
import pl.damian.wasik.spring.app.club.web.model.Registration;

public interface UserService {
    void createUser(Registration registration);

    UserEntity findByEmail(String email);

    UserEntity findBtUsername(String username);
}
