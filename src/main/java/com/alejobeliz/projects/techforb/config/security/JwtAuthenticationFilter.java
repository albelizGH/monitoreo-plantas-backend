package com.alejobeliz.projects.techforb.config.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailService userDetailService;
    List<String> listaDeStrings = List.of("/api/auth","/api/auth/login","/swagger-ui.html","/swagger-ui","/v3/api-docs","/v3/api-docs.yaml","/v3/api-docs.json","/webjars");

    @Autowired
    public JwtAuthenticationFilter(JwtService jwtService, UserDetailService userDetailService) {
        this.jwtService = jwtService;
        this.userDetailService = userDetailService;
    }


    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request,@Nonnull HttpServletResponse response,@Nonnull FilterChain filterChain) throws ServletException, IOException {
        try {
            // Obtener el URI de la solicitud
            String path = request.getRequestURI();

            for (String endpoint : listaDeStrings) {
                if (path.contains(endpoint)) {
                    filterChain.doFilter(request, response);
                    return;
                }
            }

            String tokenJWT = obtenerToken(request);
            DecodedJWT tokenDecodificado = jwtService.validarToken(tokenJWT);
            String correo = jwtService.getEmailOfToken(tokenDecodificado);
            ClientUserDetail clientUserDetail = userDetailService.loadUserByUsername(correo);

            if (!clientUserDetail.isEnabled()) {
                throw new IllegalStateException("El usuario con email " + correo + " está inactivo.");
            }

            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(clientUserDetail, null, clientUserDetail.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(request, response);

        } catch (RuntimeException e) {
            logger.error("Error de autenticación: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    //Busco en el encabezado en la parte de Authorization primero que este, y si esta quito la parte de Bearer para quedarme con el token
    private String obtenerToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.replace("Bearer ", "");
        }
        throw new RuntimeException("Token no encontrado en el encabezado de Authorization");
    }

}
