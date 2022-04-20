package com.example.apiprueba.modelo.repositorios;


import com.example.apiprueba.modelo.entidades.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioSneaker extends JpaRepository<Sneaker, Integer> {

}
