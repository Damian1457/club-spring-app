package pl.damian.wasik.spring.app.club.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(Registration registration) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registration.getUsername());
        userEntity.setEmail(registration.getEmail());
        userEntity.setUsername(passwordEncoder.encode(registration.getPassword()));
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
