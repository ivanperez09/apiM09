package com.example.apiprueba.modelo.servicios;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final ServicioUser servicioUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return servicioUser.checkByUsername(username);
    }
    public Object loadUserById(Long userId) {
        return servicioUser.consultarPerId(userId);
    }
}
