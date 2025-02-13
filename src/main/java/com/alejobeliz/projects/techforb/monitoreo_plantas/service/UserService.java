package com.alejobeliz.projects.techforb.monitoreo_plantas.service;

import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.user.NewUserRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.user.UpdateUserRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response.UserResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public List<UserResponseDTO> getAllUsers() {
        return null;
    }

    public UserResponseDTO getUserById(Long id) {
        return null;
    }

    public UserResponseDTO createUser(NewUserRequestDTO userRequestDTO) {
        return null;
    }

    public UserResponseDTO updateUser(Long id, UpdateUserRequestDTO userRequestDTO) {
        return null;
    }

    public void deleteUser(Long id) {

    }
}
