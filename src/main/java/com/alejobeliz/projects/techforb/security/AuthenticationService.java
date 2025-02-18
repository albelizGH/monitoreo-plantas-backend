package com.alejobeliz.projects.techforb.security;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private UserDetailService userDetailService;

    public AuthenticationService(AuthenticationManager authenticationManager, JwtService jwtService, UserDetailService userDetailService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailService=userDetailService;
    }

    public WebToken autenticarLogin(LoginDTO data){
        UsernamePasswordAuthenticationToken tokenDeAutenticacion = new UsernamePasswordAuthenticationToken(data.email(),data.password());
        Authentication authenticacion = authenticationManager.authenticate(tokenDeAutenticacion);
        return new WebToken(jwtService.generateToken(authenticacion));
    }
}
