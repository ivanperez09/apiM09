package com.example.apiprueba.modelo.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.apiprueba.modelo.entidades.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RepositorioUser extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
