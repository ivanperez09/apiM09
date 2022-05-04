package com.example.apiprueba.modelo.servicios;

import com.example.apiprueba.modelo.entidades.User;
import com.example.apiprueba.modelo.repositorios.RepositorioUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ServicioUser {
    private final RepositorioUser repositorioUser;
    private final PasswordEncoder xifrat;

    public User checkByUsername(String username) {
        return repositorioUser.findByUsername(username).orElse(null);
    }
    public User creatNewUser (User newUser) {
        //falta controlar que els 2 passwords del client coincideixen
        //passar un UsuariCreacioDTO
        newUser.setPassword(xifrat.encode(newUser.getPassword()));
        repositorioUser.save(newUser);
        return newUser;
    }
    public User consultarPerId(Long id){
        return repositorioUser.findById(id).orElse(null);
    }

    public List<User> llistarUsuaris(){
        return repositorioUser.findAll();
    }
}
