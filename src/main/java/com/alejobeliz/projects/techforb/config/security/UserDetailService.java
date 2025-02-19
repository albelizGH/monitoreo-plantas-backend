package com.alejobeliz.projects.techforb.config.security;



import com.alejobeliz.projects.techforb.entity.User;
import com.alejobeliz.projects.techforb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ClientUserDetail loadUserByUsername(String email) throws UsernameNotFoundException {
        User clienteDb= userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + email + " no esta registrado."));
        return new ClientUserDetail(clienteDb);
    }


}