package com.example.apiprueba.modelo.repositorios;


import com.example.apiprueba.modelo.entidades.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioSneaker extends JpaRepository<Sneaker, Integer> {

}
