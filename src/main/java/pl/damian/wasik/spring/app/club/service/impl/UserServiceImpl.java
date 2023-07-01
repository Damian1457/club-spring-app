package pl.damian.wasik.spring.app.club.service.impl;

import org.springframework.stereotype.Service;
import pl.damian.wasik.spring.app.club.repository.RoleRepository;
import pl.damian.wasik.spring.app.club.repository.UserRepository;
import pl.damian.wasik.spring.app.club.repository.entity.RoleEntity;
import pl.damian.wasik.spring.app.club.repository.entity.UserEntity;
import pl.damian.wasik.spring.app.club.service.UserService;
import pl.damian.wasik.spring.app.club.web.model.Registration;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void createUser(Registration registration) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registration.getUsername());
        userEntity.setEmail(registration.getEmail());
        userEntity.setUsername(registration.getPassword());
        RoleEntity roleEntity = roleRepository.findByName("USER");
        userEntity.setRoles(Arrays.asList(roleEntity));
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findBtUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
