package com.alejobeliz.projects.techforb.service;

import com.alejobeliz.projects.techforb.dto.request.user.NewUserRequestDTO;
import com.alejobeliz.projects.techforb.dto.response.UserResponseDTO;
import com.alejobeliz.projects.techforb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IUserService {

    UserResponseDTO createUser(NewUserRequestDTO user);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByUsername(String username);

    User updateUser(Long id, User user);

    void deleteUser(Long id);


}
