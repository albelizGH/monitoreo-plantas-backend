package com.alejobeliz.projects.techforb.service;

import com.alejobeliz.projects.techforb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IUserService {

    User createUser(User user);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByUsername(String username);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
