package com.alejobeliz.projects.techforb.service.impl;

import com.alejobeliz.projects.techforb.dto.request.user.NewUserRequestDTO;
import com.alejobeliz.projects.techforb.dto.response.UserResponseDTO;
import com.alejobeliz.projects.techforb.entity.User;
import com.alejobeliz.projects.techforb.repository.UserRepository;
import com.alejobeliz.projects.techforb.service.IUserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDTO createUser(NewUserRequestDTO user) {
        Optional<User> clienteExsitente = userRepository.findByEmail(user.email());
        if (clienteExsitente.isPresent()) {
            throw new EntityNotFoundException("Ya existe el usuario con correo: " + user.email());
        }
        String encriptedPassword =passwordEncoder.encode(user.password());
        NewUserRequestDTO userRequestDTO = new NewUserRequestDTO(user.username(), user.email(), encriptedPassword);
        User cliente = new User(userRequestDTO);
        userRepository.save(cliente);
        return new UserResponseDTO (cliente);
    }


    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (!userRepository.existsById(id)) {
            return null;
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
