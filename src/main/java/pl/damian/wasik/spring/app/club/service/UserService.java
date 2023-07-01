package pl.damian.wasik.spring.app.club.service;

import org.springframework.stereotype.Service;
import pl.damian.wasik.spring.app.club.web.model.Registration;

@Service
public interface UserService {
    void createUser(Registration registration);
}
