package com.alejobeliz.projects.techforb.dto.response;

import com.alejobeliz.projects.techforb.entity.User;

public record UserResponseDTO(
        Long id,
        String username,
        String email
) {
    public UserResponseDTO(User user){
        this(user.getId(), user.getUsername(), user.getEmail());
    }
}
